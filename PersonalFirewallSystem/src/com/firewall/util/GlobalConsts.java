package com.firewall.util;

import java.awt.Font;

/**
 * 全局常量类
 * 用户界面显示的功能菜单
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class GlobalConsts {
    
    private GlobalConsts() {}
    
    public static final Font WINDOW_FONT = new Font("宋体", Font.BOLD, 14);
    public static final String WINDOW_TITLE = "个人防火墙系统";
    
    //  开始：设置监听端口、启动、停止
    public static final String MENU_START = "开始";
    public static final String MENUITEM_SET_PORT = "设置监听端口";
    public static final String MENUITEM_START = "启动";
    public static final String MENUITEM_STOP = "停止";
    
    // 查看：实时状态、过滤记录、详细日志
    public static final String MENU_VIEW = "查看";
    public static final String MENUITEM_REAL_TIME_STATE = "实时状态";
    public static final String MENUITEM_REJECT_RECORD = "拦截记录";
    public static final String MENUITEM_DETAIL_LOG = "详细日志";

    // 黑(白)名单网站和IP：添加 删除 修改 查询
    public static final String MENU_WEBSITE = "黑(白)名单网站";
    public static final String MENU_IP = "黑(白)名单IP";
    public static final String SHARE_MENUITEM_INSERT = "添加";
    public static final String SHARE_MENUITEM_DELETE = "删除";
    public static final String SHARE_MENUITEM_UPDATE = "修改";
    public static final String SHARE_MENUITEM_SELECT = "查询";
    
    // 防火墙模式：一般模式/严格模式
    public static final String MENU_FIREWALL_PATTERN = "防火墙模式";
    public static final String CHECKBOXMENUITEM_STRICT_PATTERN = "严格模式";
    
    // 帮助：使用说明、关于
    public static final String MENU_HELP = "帮助";
    public static final String MENUITEM_HELP_USE = "使用说明";
    public static final String MENUITEM_ABOUT = "关于";
}
