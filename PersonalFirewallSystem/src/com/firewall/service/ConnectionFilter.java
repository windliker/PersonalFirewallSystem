package com.firewall.service;

import java.net.Socket;

/**
 *  连接请求过滤模块，定义了安全规则审核和通信代理的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface ConnectionFilter {
    // 合法性检查
    public abstract boolean checkRule(String server, String serverIp);
    // 通信代理
    public abstract void proxyRequest(String server, int port, 
            byte[] msg, int msgLen, Socket clientSocks);
}
