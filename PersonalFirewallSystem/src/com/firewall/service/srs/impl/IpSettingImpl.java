package com.firewall.service.srs.impl;

import java.awt.Container;

import javax.swing.JMenu;

import com.firewall.action.IpSettingAction;
import com.firewall.service.srs.IpSetting;
import com.firewall.util.GlobalConsts;

/**
 * 黑（白）名单IP菜单的实现，包含增、删、改、查菜单项
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class IpSettingImpl implements IpSetting {

    private void addConfigure(Container contentPane) {
        add.setText(GlobalConsts.SHARE_MENUITEM_INSERT);
        add.setFont(GlobalConsts.WINDOW_FONT);
        add.addActionListener(event -> {
            IpSettingAction ipMenu = new IpSettingAction();
            ipMenu.handleAdd(contentPane);
        });
    }

    private void deleteConfigure(Container contentPane) {
        delete.setText(GlobalConsts.SHARE_MENUITEM_DELETE);
        delete.setFont(GlobalConsts.WINDOW_FONT);
        delete.addActionListener(event -> {
            IpSettingAction ipMenu = new IpSettingAction();
            ipMenu.handleDelete(contentPane);
        });
    }

    private void updateConfigure(Container contentPane) {
        update.setText(GlobalConsts.SHARE_MENUITEM_UPDATE);
        update.setFont(GlobalConsts.WINDOW_FONT);
        update.addActionListener(event -> {
            IpSettingAction ipMenu = new IpSettingAction();
            ipMenu.handleUpdate(contentPane);
        });
    }

    private void inquiryConfigure(Container contentPane) {
        inquiry.setText(GlobalConsts.SHARE_MENUITEM_SELECT);
        inquiry.setFont(GlobalConsts.WINDOW_FONT);
        inquiry.addActionListener(event -> {
            IpSettingAction ipMenu = new IpSettingAction();
            ipMenu.handleInquiry(contentPane);
        });
    }

    @Override
    public JMenu ipMenuConfigure(Container contentPane) {
        ipMenu.setText(GlobalConsts.MENU_IP);
        ipMenu.setFont(GlobalConsts.WINDOW_FONT);
        
        addConfigure(contentPane);
        deleteConfigure(contentPane);
        updateConfigure(contentPane);
        inquiryConfigure(contentPane);
        ipMenu.add(add);  
        ipMenu.add(delete);
        ipMenu.add(update);
        ipMenu.add(inquiry);

        return ipMenu;
    }

}
