package com.firewall.action;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.firewall.dao.LogDAO;
import com.firewall.dao.RecordDAO;
import com.firewall.dao.impl.LogDAOImpl;
import com.firewall.dao.impl.RecordDAOImpl;
import com.firewall.model.Log;
import com.firewall.model.Record;

/**
 * 查看菜单事件处理
 * 实时监控
 * 拦截记录
 * 详细日志
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class LogAuditAction {
    
    public void handleRealTime(Container contentPane,
            JTextArea realTimeArea) {
        displayRealTime(contentPane, realTimeArea);
    }

    public void handleRejectRecord(Container contentPane) {
        contentPane.removeAll();
        // 边界布局的mainPane
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());
        // 文本域,显示拦截记录
        JTextArea recordArea = new JTextArea();
        // 查询数据库并把record表中reject_record字段的内容一条条追加到recordArea
        RecordDAO recordDAO = new RecordDAOImpl();
        List<Record> records = recordDAO.findAll();
        for (Record record : records) {
            recordArea.append(record.getRejectRecord());
        }
        recordArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(recordArea);
        mainPane.add(scrollPane);
        // 流式布局的bottomPane
        JPanel bottomPane = new JPanel();
        JButton clearBtn = new JButton("清空记录");
        clearBtn.addActionListener(event -> {
            recordDAO.empty();
            // 调用自身,更新显示
            handleRejectRecord(contentPane);
        });
        bottomPane.add(clearBtn);
        
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.add(bottomPane, BorderLayout.SOUTH);
        contentPane.validate();        
    }

    public void handleDetailLog(Container contentPane) {
        contentPane.removeAll();
        // 边界布局的mainPane
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());
        // 文本域
        // 显示日志
        JTextArea logArea = new JTextArea();
        LogDAO logDAO = new LogDAOImpl();
        List<Log> logs = logDAO.findAll();
        for (Log log : logs) {
            logArea.append(log.getDetailLog());
        }
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        mainPane.add(scrollPane);
        // 流式布局的bottomPane
        JPanel bottomPane = new JPanel();
        JButton clearBtn = new JButton("清空日志");
        clearBtn.addActionListener(event -> {
            logDAO.empty();
            // 调用自身,更新显示
            handleDetailLog(contentPane);
        });
        bottomPane.add(clearBtn);
        
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.add(bottomPane, BorderLayout.SOUTH);
        contentPane.validate();
    }
    
    private void displayRealTime(Container contentPane,
            JTextArea realTimeArea) {
        contentPane.removeAll();
        realTimeArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(realTimeArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.validate();
    }
    
}
