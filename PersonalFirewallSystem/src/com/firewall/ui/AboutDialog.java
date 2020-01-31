package com.firewall.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 该类继承了JDialog类
 * 用于 [帮助]菜单下[关于]菜单项的显示
 * @version 1.0.0 2019年4月22日
 * @author liukailiang
 *
 */
public class AboutDialog extends JDialog {
    
    private static final long serialVersionUID = 1682887528110529814L;

    public AboutDialog(JFrame frame) {
        super(frame);
        initUI();
    }

    private void initUI() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JTextArea info = new JTextArea();
        Font font = new Font("宋体", Font.PLAIN, 13);
        info.setFont(font);
        String note = "个人防火墙系统\npersonal firewall system\n\n"
                + "版本：2019(1.0.0)\n\n";
        String introduce = 
                  "本防火墙程序具有防火墙工作模式选择功能、\n"
                + "安全规则设定功能、网站和IP过滤功能、\n"
                + "实时监控功能、拦截记录功能、详细日志\n"
                + "等功能，轻巧、实用、易用等特点。\n\n";
        String author = "作者：刘开亮\n";
        String contactAuthor = "联系作者：someone@example.com";
        info.append(note);
        info.append(introduce);
        info.append(author);
        info.append(contactAuthor);
        info.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(info);
        contentPane.add(scrollPane);
    }
}
