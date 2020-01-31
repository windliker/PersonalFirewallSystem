package com.firewall.test;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import com.firewall.util.WriteLogUtil;

/**
 * 测试WriteLogUtil工具类
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestWriteLogUtil {
    
    @Test
    public void testGetTimeStamp() {
        String timeStamp = WriteLogUtil.getTimeStamp();
        System.out.print(timeStamp);
    }
    
    @Test
    public void testWriteLog() {
        JFrame testWindow = new JFrame();
        JTextArea textArea = new JTextArea();
        textArea.append("第一次插入\n");
        textArea.append("第二次插入\n");
        textArea.append("第三次插入\n");
        Container contentPane = testWindow.getContentPane();
        contentPane.add(textArea, BorderLayout.CENTER);
        testWindow.setSize(800, 600);
        testWindow.setLocationRelativeTo(testWindow.getOwner());
        testWindow.setTitle("测试");
        testWindow.setVisible(true);
        testWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String logItem = "测试\n";
        WriteLogUtil.writeLog(textArea, logItem);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
