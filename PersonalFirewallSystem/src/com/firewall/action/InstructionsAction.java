package com.firewall.action;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.firewall.ui.AboutDialog;

/**
 * 帮助菜单事件处理
 * 使用帮助、关于（系统介绍）
 * @version 1.0.0 2019年4月23日
 * @author liukailiang 
 *
 */
public class InstructionsAction {

    public void handleHelpUse(Container contentPane) {
        contentPane.removeAll();
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());
        // 文本域
        JTextArea helpArea = new JTextArea();
        helpArea.setFont(new Font("宋体", Font.PLAIN, 15));
        String helpUse = "使用说明：\n\t"
                + "首先需要在开始菜单设置防火墙监听的端口号，默认是2019，\n\t"
                + "如果与其他程序的端口产生冲突，可以重新设置端口号（1024-49151范围内）。\n\t"
                + "接着，根据安全需求可以在防火墙模式中选择勾选严格模式与否，默认不勾选是普通模式。\n\t"
                + "如果是普通模式，则可在网站和IP中添、删、改、查黑名单；\n\t"
                + "如果是严格模式，则在网站和IP中添、删、改、查的就是白名单了。\n\t"
                + "完成上述设定就可以点击开始菜单->启动，让防火墙\"真正地工作\"起来。\n\t"
                + "最后，打开浏览器设置HTTP代理指向127.0.0.1:设置的端口号，就可让防火墙保护PC。";
        helpArea.append(helpUse);
        helpArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(helpArea);
        mainPane.add(scrollPane);
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.validate();
    }
    
    public void handleIntroduction(JFrame frame) {
        AboutDialog aboutDialog = new AboutDialog(frame);
        aboutDialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        aboutDialog.setTitle("关于");
        aboutDialog.setSize(300, 250);
        aboutDialog.setLocationRelativeTo(aboutDialog.getOwner());
        aboutDialog.setVisible(true);
        aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
