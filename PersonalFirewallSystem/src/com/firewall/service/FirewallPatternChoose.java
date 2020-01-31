package com.firewall.service;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

/**
 * 防火墙模式菜单的定义，确认框菜单项：严格模式（勾选）或普通模式(不勾选，默认)，
 * 对应于防火墙工作模式选择模块
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */

public interface FirewallPatternChoose {
    public static final JMenu firewallPatternMenu = new JMenu();
    public static final JCheckBoxMenuItem strictPattern = new JCheckBoxMenuItem();
    // 定义了该菜单具体配置的方法
    public abstract JMenu firewallPatternMenuConfigure();

}
