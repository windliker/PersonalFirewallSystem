package com.firewall.service.srs;

import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 接口，定义了黑（白）名单IP菜单，
 * 对应安全规则设置模块中的IP过滤规则设置
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface IpSetting {
    // 黑(白)名单ip的增、删、改、查
    public static final JMenu ipMenu = new JMenu();
    public static final JMenuItem add = new JMenuItem();
    public static final JMenuItem delete = new JMenuItem();
    public static final JMenuItem update = new JMenuItem();
    public static final JMenuItem inquiry = new JMenuItem();

    // 定义该菜单的具体配置方法
    public abstract JMenu ipMenuConfigure(Container contentPane);
    

}
