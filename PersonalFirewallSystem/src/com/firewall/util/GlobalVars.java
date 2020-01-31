package com.firewall.util;

/**
 * 全局变量类
 *定义了三个全局变量： 端口号、防火墙工作模式、防火墙工作状态
 * @version 1.0.0 2019年4月22日
 * @author liukailiang
 *
 */
public class GlobalVars {
    
    private GlobalVars() {}
    
    /**
     * 代理服务器端口号，默认值2019
     */
    public static int proxyPort = 2019;
    
    /**
     * 防火墙工作模式，默认false。
     * 用户勾选[严格模式]，说明安全需求高，将变为true，采用白名单机制；
     * 用户未勾选或取消勾选[严格模式]，即处于普通模式，说明为一般安全需求，将变为false，采用黑名单机制。
     */
    public static boolean strictPattern = false;
    
    /**
     * 防火墙工作状态（代理启动、代理终止），默认为false，代理终止状态。
     * 用户点击[启动]菜单项，变为true，防火墙正式开始工作即开始代理；
     * 用户点击[停止]菜单项变false，停止代理。
     */
    public static boolean on = false;
}
