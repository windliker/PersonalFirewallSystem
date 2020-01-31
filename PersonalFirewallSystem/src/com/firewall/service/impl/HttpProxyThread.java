package com.firewall.service.impl;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import com.firewall.util.GlobalVars;
import com.firewall.util.WriteLogUtil;

import java.io.IOException;

/**
 * http代理线程类，负责监听客户端发来的连接请求，采用单例模式。
 * 对于每一个客户端请求，交给处理请求线程来处理
 * @version 1.0.0 2019年4月23日
 * @author liukailiang
 *
 */
public class HttpProxyThread extends Thread {
    
    private JTextArea realTimeArea;
    private static HttpProxyThread instance = null;
    
    private HttpProxyThread(JTextArea realTimeArea) {
        this.realTimeArea = realTimeArea;
    }
    
    public static HttpProxyThread getInstance(JTextArea realTimeArea) {
        if (instance == null) {
            instance = new HttpProxyThread(realTimeArea);
        }
        return instance;
    }
	
    @Override
    public void run() {
	    
		//启动代理
		ServerSocket proxyServer = null;
	    
		try {
			proxyServer = new ServerSocket(GlobalVars.proxyPort);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	    String logItem = null;
	    
		logItem = WriteLogUtil.getTimeStamp() + "代理启动\n";
		WriteLogUtil.writeLog(realTimeArea, logItem);
		
		//处理连接请求
		while (GlobalVars.on) {
			//获取客户端socket			
			Socket clientSocks = null;
			try {
				clientSocks	= proxyServer.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
						
			// 每一个客户端请求创建一个线程处理
			// 待使用线程池,线程队列
			Thread handleThread = new Thread(new HandleRequestThread(clientSocks, realTimeArea));
			handleThread.start();	
		}
		
		// 释放资源
		try {
            proxyServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logItem = WriteLogUtil.getTimeStamp() + "代理终止\n";
        WriteLogUtil.writeLog(realTimeArea, logItem);	
	}

}