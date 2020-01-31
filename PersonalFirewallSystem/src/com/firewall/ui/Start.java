package com.firewall.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.firewall.util.GlobalConsts;
import com.firewall.util.GlobalVars;

/**
 * 程序启动类
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class Start {
    public static void main(String[] args) {
        // 创建一个UserWindow的对象
        UserWindow userWindow = new UserWindow();
        // 设置窗口属性
        userWindow.setSize(800, 600);
        userWindow.setLocationRelativeTo(userWindow.getOwner());
        userWindow.setTitle(GlobalConsts.WINDOW_TITLE);
        userWindow.setResizable(false);
        userWindow.setVisible(true);
        // 关闭窗口事件处理：释放资源，退出程序
        userWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 先终止代理
                GlobalVars.on = false;
                userWindow.setVisible(false);
                try {
                    // 等待代理线程释放完ServerSocket资源
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}
