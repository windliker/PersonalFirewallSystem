package com.firewall.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JTextArea;

import com.firewall.dao.RecordDAO;
import com.firewall.dao.impl.RecordDAOImpl;
import com.firewall.service.ConnectionFilter;
import com.firewall.util.HttpRequestParseUtil;
import com.firewall.util.WriteLogUtil;

/**
 * 客户端http请求处理线程类，
 * 首先获取客户端的请求报文，解析出其所请求的主机名，据此获得对应的ip地址，
 * 然后进行安全规则审核，审核通过进行代理，否则拦截该请求
 * @version 1.0.0 2019年4月22日
 * @author liukailiang
 *
 */
public class HandleRequestThread implements Runnable {
	
    private Socket clientSocks;
	private JTextArea textArea;
    
	HandleRequestThread(Socket clientSocks, JTextArea textArea) {
		this.clientSocks = clientSocks;
		this.textArea = textArea;
	}

	@Override
	public void run() {
        String server = null;
		try {
			Instant begin = Instant.now();
			//获取客户端输入流
			InputStream	clientInputS = clientSocks.getInputStream();
			
			//获取客户端发送的数据
			byte[] readFromClient = new byte[2048];
			int readLength = clientInputS.read(readFromClient);
			if (readLength == -1) {
			    System.out.println(WriteLogUtil.getTimeStamp() +
			            "未读取到客户端请求信息");
				return;
			}
			
			// 将收到的字节数组形式的http请求报文转换为String,解析出请求的服务器名
			String httpRequest = new String(readFromClient, 0, readLength);
			server = HttpRequestParseUtil.getHost(httpRequest);
			String serverIp = InetAddress.getByName(server).getHostAddress();
			int	port = 80;
	        
			// 安全规则检查
			ConnectionFilter filter = new ConnectionFilterImpl();
	        String serverSocksAddr = server + "[" + serverIp + "]:" + port;
	        String client = clientSocks.getInetAddress().getHostName();
	        String clientIp = clientSocks.getInetAddress().getHostAddress();
	        String clientSocksAddr = client + "[:" + clientIp + "]:" 
	                    + clientSocks.getPort();
	        String logItem;
			if(filter.checkRule(server, serverIp)) {
			    // 通过检查,代理通信
		        logItem = WriteLogUtil.getTimeStamp() + clientSocksAddr
		                + "->" + serverSocksAddr + "发起连接\n";
		        WriteLogUtil.writeLog(textArea, logItem);
			    filter.proxyRequest(server, port, readFromClient,
			            readLength, clientSocks);
			    // 代理通信完成
		        Instant end = Instant.now();
		        logItem = WriteLogUtil.getTimeStamp() + serverSocksAddr
		                + "->" + clientSocksAddr + "传输完成，耗时" + Duration
		                .between(begin, end).toMillis() + "毫秒\n";
		        WriteLogUtil.writeLog(textArea, logItem);
			} else {
		        // 对不合法的请求的处理
			    logItem = WriteLogUtil.getTimeStamp() + "拦截了" + clientSocksAddr + "->"
		                    + serverSocksAddr + "的访问\n";
		        WriteLogUtil.writeLog(textArea, logItem);
		        RecordDAO recordDAO = new RecordDAOImpl();
		        recordDAO.add(logItem);
		        
	            if (clientInputS != null) {
	                try {
	                    clientInputS.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } finally {
	                    clientInputS = null;
	                }
	            }
	            if (clientSocks != null) {
	                try {
	                    clientSocks.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } finally {
	                    clientSocks = null;
	                }
	            }
			}
		
		} catch(UnknownHostException e) {
		    String error = WriteLogUtil.getTimeStamp() + "——未知主机异常："
		            + server;
		    System.out.println(error);
			return;
		} catch(SocketException e) {
            String error = WriteLogUtil.getTimeStamp() + "——socket已断开："
                    + server;
            System.out.println(error);
            return;
		} catch(IOException e) {
            String error = WriteLogUtil.getTimeStamp() + "——IO异常："
                    + server;
            System.out.println(error);
			return;
		}
		
	}
	
}
