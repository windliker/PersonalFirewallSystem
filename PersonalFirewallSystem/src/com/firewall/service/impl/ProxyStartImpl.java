package com.firewall.service.impl;

import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JTextArea;

import com.firewall.action.ProxyStartAction;
import com.firewall.service.ProxyStart;
import com.firewall.util.GlobalConsts;

/**
 * 开始菜单的实现
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class ProxyStartImpl implements ProxyStart {

    // 设置监听端口菜单项
    private void setPortConfigure(Container contentPane) {
        setPort.setText(GlobalConsts.MENUITEM_SET_PORT);
        setPort.setFont(GlobalConsts.WINDOW_FONT);
        setPort.addActionListener(event -> {
            ProxyStartAction startMenuAction = new ProxyStartAction();
            startMenuAction.handleSetPort(contentPane);
        });
    }
    
    // 启动菜单项
    private void startupConfigure(Container contentPane,
            JTextArea realTimeArea) {
        startup.setText(GlobalConsts.MENUITEM_START);
        startup.setFont(GlobalConsts.WINDOW_FONT);
        startup.addActionListener(event -> {
            ProxyStartAction startMenuAction = new ProxyStartAction();
            startMenuAction.handleStartup(contentPane, realTimeArea);
        });
    }

    // 停止菜单项
    private void stopConfigure(Container contentPane, 
            JTextArea realTimeArea) {
        stop.setText(GlobalConsts.MENUITEM_STOP);
        stop.setFont(GlobalConsts.WINDOW_FONT);
        stop.addActionListener(event -> {
            ProxyStartAction startMenuAction = new ProxyStartAction();
            startMenuAction.handleStop(contentPane, realTimeArea);

        });
    }
    
    @Override
    public JMenu startMenuConfigure(Container contentPane,
            JTextArea realTimeArea) {
        startMenu.setText(GlobalConsts.MENU_START);
        startMenu.setFont(GlobalConsts.WINDOW_FONT);
        setPortConfigure(contentPane);
        startupConfigure(contentPane, realTimeArea);
        stopConfigure(contentPane, realTimeArea);
        startMenu.add(setPort);
        startMenu.add(startup);
        startMenu.add(stop);
        return startMenu;
    }
}
