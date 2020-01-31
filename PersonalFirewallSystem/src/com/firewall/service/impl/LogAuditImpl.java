package com.firewall.service.impl;

import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JTextArea;

import com.firewall.action.LogAuditAction;
import com.firewall.service.LogAudit;
import com.firewall.util.GlobalConsts;

/**
 * 查看菜单的实现
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class LogAuditImpl implements LogAudit {

    // 实时状态菜单项
    private void realTimeConfigure(Container contentPane, JTextArea realTimeArea) {
        realTime.setText(GlobalConsts.MENUITEM_REAL_TIME_STATE);
        realTime.setFont(GlobalConsts.WINDOW_FONT);
        // 显示实时通信记录
        realTime.addActionListener(event -> {
            LogAuditAction viewMenu = new LogAuditAction();
            viewMenu.handleRealTime(contentPane, realTimeArea);
        });
    }

    // 拦截记录菜单项
    private void rejectRecordConfigure(Container contentPane) {
        rejectRecord.setText(GlobalConsts.MENUITEM_REJECT_RECORD);
        rejectRecord.setFont(GlobalConsts.WINDOW_FONT);
        // 显示过滤记录
        rejectRecord.addActionListener(event -> {
            LogAuditAction viewMenu = new LogAuditAction();
            viewMenu.handleRejectRecord(contentPane);
        });
    }
    
    // 详细日志菜单项
    private void detailLogConfigure(Container contentPane) {
        detailLog.setText(GlobalConsts.MENUITEM_DETAIL_LOG);
        detailLog.setFont(GlobalConsts.WINDOW_FONT);
        // 显示详细日志
        detailLog.addActionListener(event -> {
            LogAuditAction viewMenu = new LogAuditAction();
            viewMenu.handleDetailLog(contentPane);
        });
    }

    @Override
    public JMenu viewMenuConfigure(Container contentPane,
            JTextArea realTimeArea) {
        viewMenu.setText(GlobalConsts.MENU_VIEW);
        viewMenu.setFont(GlobalConsts.WINDOW_FONT);
        realTimeConfigure(contentPane, realTimeArea);
        rejectRecordConfigure(contentPane);
        detailLogConfigure(contentPane);
        viewMenu.add(realTime);
        viewMenu.add(rejectRecord);
        viewMenu.add(detailLog);
        return viewMenu;
    }
}
