package com.firewall.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import com.firewall.dao.IpDAO;
import com.firewall.dao.WebsiteDAO;
import com.firewall.dao.impl.IpDAOImpl;
import com.firewall.dao.impl.WebsiteDAOImpl;
import com.firewall.model.Ip;
import com.firewall.model.Website;
import com.firewall.service.ConnectionFilter;
import com.firewall.util.GlobalVars;
import com.firewall.util.WriteLogUtil;

/**
 *  连接请求过滤模块的实现，安全规则检查，通信代理
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class ConnectionFilterImpl implements ConnectionFilter {

    @Override
    public boolean checkRule(String server, String serverIp) {
        
        // 根据安全规则,检查客户端请求是否合法
        // 默认的黑名单模式
        boolean pass = true; // true表示请求合法，false表示请求不合法
        
        WebsiteDAO websiteDAO = new WebsiteDAOImpl();
        List<Website> websites = websiteDAO.findAll();
        for (Website website : websites) {
            if (server.equals(website.getWebsiteName())) {
                pass = false;
            }
        }
        
        IpDAO ipDAO = new IpDAOImpl();
        List<Ip> ips = ipDAO.findAll();
        for (Ip ip : ips) {
            if (serverIp.equals(ip.getIpAddress())) {
                pass = false;
            }
        }
        
        // 严格模式，白名单模式
        if (GlobalVars.strictPattern) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public void proxyRequest(String server, int port, byte[] msg,
            int msgLen, Socket clientSocks) {
        // 对合法的请求进行代理
        // 与服务器建立连接,获取服务器端socket
        Socket serverSocks = null;
        OutputStream serverOutputS = null;
        InputStream serverInputS = null;
        OutputStream clientOutputS = null;

        try {
            serverSocks = new Socket(server, port);
            serverOutputS = serverSocks.getOutputStream();
            serverInputS = serverSocks.getInputStream();
            clientOutputS = clientSocks.getOutputStream();
            
            //向服务器转发请求
            serverOutputS.write(msg, 0, msgLen);
            
            //向客户端转发响应
            byte[] readFromServer = new byte[4096];
            int readLen;
            while ((readLen = serverInputS.read(readFromServer)) != -1) {
                clientOutputS.write(readFromServer, 0, readLen);
            }
 
            clientOutputS.flush(); //传输完成
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
        } finally {
            // 释放资源
            if (serverInputS != null) {
                try {
                    serverInputS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    serverInputS = null;
                }
            }
            if (serverOutputS != null) {
                try {
                    serverOutputS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    serverOutputS = null;
                }
            }
            if (serverSocks != null) {
                try {
                    serverSocks.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    serverSocks = null;
                }
            }
            if (clientOutputS != null) {
                try {
                    clientOutputS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    clientOutputS = null;
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

    }

}
