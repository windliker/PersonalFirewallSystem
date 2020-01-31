package com.firewall.action;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.firewall.service.impl.HttpProxyThread;
import com.firewall.util.GlobalVars;

/**
 * 开始菜单事件处理
 * 设置端口号
 * 启动处理
 * 停止处理
 * @version 1.0.0 2019年4月23日
 * @author liukailiang
 *
 */
public class ProxyStartAction {
    
    public ProxyStartAction() {}

    public void handleSetPort(Container contentPane) {
        // 清空窗口的内容窗格
        contentPane.removeAll();
        // 一个流式布局的面板
        JPanel mainPane = new JPanel();
        
        JLabel noticeLabel = new JLabel("当前监听端口：");
        JTextField inputField = 
                new JTextField(String.valueOf(GlobalVars.proxyPort), 6);
        JButton saveBtn = new JButton("确定");
        saveBtn.addActionListener(event -> {
            // 未对输入端口号的合法性以及冲突性做检查
            GlobalVars.proxyPort = Integer.parseInt(inputField.getText());
            JOptionPane.showMessageDialog(mainPane, "设置成功");
        });
        
        mainPane.add(noticeLabel);
        mainPane.add(inputField);
        mainPane.add(saveBtn);
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.validate();
    }
    
    public void handleStartup(Container contentPane,
            JTextArea realTimeArea) {
        GlobalVars.on = true;
        HttpProxyThread proxyThread = HttpProxyThread.getInstance(realTimeArea);
        if (!proxyThread.isAlive()) {
            proxyThread.start();
        }
        displayRealTime(contentPane, realTimeArea);
    }
    
    public void handleStop(Container contentPane, 
            JTextArea realTimeArea) {
        // 关闭ServerSocket，不再对新的请求进行处理，并未实现销毁所有代理线程
        GlobalVars.on = false;
        displayRealTime(contentPane, realTimeArea);
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
