package com.firewall.service;

import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 * 定义了查看菜单：实时状态菜单项、拦截记录菜单项、详细日志菜单项；
 * 对应于 日志审计模块
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface LogAudit {

    public static final JMenu viewMenu = new JMenu();
    public static final JMenuItem realTime = new JMenuItem();
    public static final JMenuItem rejectRecord = new JMenuItem();
    public static final JMenuItem detailLog = new JMenuItem();
    // 定义查看菜单具体配置的方法
    public abstract JMenu viewMenuConfigure(Container contentPane,
            JTextArea realTimeArea);

}
