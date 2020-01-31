package com.firewall.service.srs.impl;

import java.awt.Container;

import javax.swing.JMenu;

import com.firewall.action.WebsiteSettingAction;
import com.firewall.service.srs.WebsiteSetting;
import com.firewall.util.GlobalConsts;

/**
 * 黑（白）名单网站菜单的实现，包含增、删、改、查菜单项
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class WebsiteSettingImpl implements WebsiteSetting {
    
    private void addConfigure(Container contentPane) {
        add.setText(GlobalConsts.SHARE_MENUITEM_INSERT);
        add.setFont(GlobalConsts.WINDOW_FONT);
        add.addActionListener(event -> {
            WebsiteSettingAction websiteMenu = new WebsiteSettingAction();
            websiteMenu.handleAdd(contentPane);
        });
    }
    
    private void deleteConfigure(Container contentPane) {
        delete.setText(GlobalConsts.SHARE_MENUITEM_DELETE);
        delete.setFont(GlobalConsts.WINDOW_FONT);
        delete.addActionListener(event -> {
            WebsiteSettingAction websiteMenu = new WebsiteSettingAction();
            websiteMenu.handleDelete(contentPane);
        });
    }
    
    private void updateConfigure(Container contentPane) {
        update.setText(GlobalConsts.SHARE_MENUITEM_UPDATE);
        update.setFont(GlobalConsts.WINDOW_FONT);
        update.addActionListener(event -> {
            WebsiteSettingAction websiteMenu = new WebsiteSettingAction();
            websiteMenu.handleUpdate(contentPane);
        });
    }
    
    private void inquiryConfigure(Container contentPane) {
        inquiry.setText(GlobalConsts.SHARE_MENUITEM_SELECT);
        inquiry.setFont(GlobalConsts.WINDOW_FONT);
        inquiry.addActionListener(event -> {
            WebsiteSettingAction websiteMenu = new WebsiteSettingAction();
            websiteMenu.handleInquiry(contentPane);
        });
    }
    
    @Override
    public JMenu websiteMenuConfigure(Container contentPane) {
        websiteMenu.setText(GlobalConsts.MENU_WEBSITE);
        websiteMenu.setFont(GlobalConsts.WINDOW_FONT);
        addConfigure(contentPane);
        deleteConfigure(contentPane);
        updateConfigure(contentPane);
        inquiryConfigure(contentPane);
        websiteMenu.add(add);
        websiteMenu.add(delete); 
        websiteMenu.add(update);       
        websiteMenu.add(inquiry);
        return websiteMenu;
    }

}
