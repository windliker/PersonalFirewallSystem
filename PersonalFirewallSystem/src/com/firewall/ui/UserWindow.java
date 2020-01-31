package com.firewall.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import com.firewall.service.FirewallPatternChoose;
import com.firewall.service.Instructions;
import com.firewall.service.LogAudit;
import com.firewall.service.ProxyStart;
import com.firewall.service.impl.FirewallPatternChooseImpl;
import com.firewall.service.impl.InstructionsImpl;
import com.firewall.service.impl.LogAuditImpl;
import com.firewall.service.impl.ProxyStartImpl;
import com.firewall.service.srs.IpSetting;
import com.firewall.service.srs.WebsiteSetting;
import com.firewall.service.srs.impl.IpSettingImpl;
import com.firewall.service.srs.impl.WebsiteSettingImpl;

/**
 * 用户主窗口类 继承了JFrame
 * 用户启动程序后显示的窗口
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class UserWindow extends JFrame {

    private static final long serialVersionUID = 123485382631537697L;
    
    private Container contentPane;
    private JTextArea realTimeArea;
    
    private JMenuBar menuBar;
    private JMenu startMenu;
    private JMenu viewMenu;
    private JMenu websiteMenu;
    private JMenu ipMenu;   
    private JMenu firewallPatternMenu;
    private JMenu helpMenu;
    
    public UserWindow() {
        // 获取窗体的内容面板
        contentPane = getContentPane();
        // 内容面板的布局方式为边界布局
        contentPane.setLayout(new BorderLayout());
        // 创建实时显示区域的对象
        realTimeArea = new JTextArea();
        initUI();
    }
   
    private void initUI() {
        menuBar = new JMenuBar();
       
        // 开始菜单,对应启动功能模块
        ProxyStart proxyStart = new ProxyStartImpl();
        startMenu = proxyStart.startMenuConfigure(contentPane, realTimeArea);
        menuBar.add(startMenu);
        
        // 查看菜单,对应日志审计模块
        LogAudit logAudit = new LogAuditImpl();
        viewMenu = logAudit.viewMenuConfigure(contentPane, realTimeArea);
        menuBar.add(viewMenu);
                
        // 黑（白）名单网站菜单
        WebsiteSetting websiteSetting = new WebsiteSettingImpl();
        websiteMenu = websiteSetting.websiteMenuConfigure(contentPane);
        menuBar.add(websiteMenu);
        
        // 黑（白）名单IP菜单
        IpSetting ipSetting = new IpSettingImpl();
        ipMenu = ipSetting.ipMenuConfigure(contentPane);
        menuBar.add(ipMenu);
        
        // 防火墙模式菜单
        FirewallPatternChoose firewallPattern = new FirewallPatternChooseImpl();
        firewallPatternMenu = firewallPattern.firewallPatternMenuConfigure();
        menuBar.add(firewallPatternMenu);
        
        // 帮助菜单
        Instructions instructions = new InstructionsImpl();
        helpMenu = instructions.helpMenuConfigure(this, contentPane);
        menuBar.add(helpMenu);
        
        // 菜单栏添加到窗口顶部位置
        setJMenuBar(menuBar);
        
    }

}
