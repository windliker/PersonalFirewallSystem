package com.firewall.service;

import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 * 定义了开始菜单：设置监听断开菜单项，启动菜单项，停止菜单项；
 *  对应于启动功能模块
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface ProxyStart {

    // 开始菜单
    public static final JMenu startMenu = new JMenu();
    // 设置监听端口菜单项
    public static final JMenuItem setPort = new JMenuItem();
    // 启动处理菜单项
    public static final JMenuItem startup = new JMenuItem();
    // 停止处理菜单项
    public static final JMenuItem stop = new JMenuItem();
    // 定义开始菜单具体配置的方法
    public abstract JMenu startMenuConfigure(Container contentPane,
            JTextArea realTimeArea);

}
