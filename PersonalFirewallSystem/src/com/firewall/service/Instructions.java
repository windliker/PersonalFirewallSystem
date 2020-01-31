package com.firewall.service;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 定义了帮助菜单：使用说明菜单项、关于(系统介绍)菜单项；
 * 对应于系统使用模块
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface Instructions {

    public static final JMenu helpMenu = new JMenu();
    public static final JMenuItem helpUse = new JMenuItem();
    public static final JMenuItem about = new JMenuItem();
    // 定义帮助菜单具体配置的方法
    public abstract JMenu helpMenuConfigure(JFrame frame, 
            Container contentPane);
    
}
