package com.firewall.service.impl;

import javax.swing.JMenu;

import com.firewall.service.FirewallPatternChoose;
import com.firewall.util.GlobalConsts;
import com.firewall.util.GlobalVars;

/**
 * 防火墙模式菜单的实现
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class FirewallPatternChooseImpl implements FirewallPatternChoose {

    @Override
    public JMenu firewallPatternMenuConfigure() {
        firewallPatternMenu.setText(GlobalConsts.MENU_FIREWALL_PATTERN);
        firewallPatternMenu.setFont(GlobalConsts.WINDOW_FONT);
        strictPattern.setText(GlobalConsts.CHECKBOXMENUITEM_STRICT_PATTERN);
        strictPattern.setFont(GlobalConsts.WINDOW_FONT);
        strictPattern.addActionListener(event -> GlobalVars.strictPattern
                = strictPattern.isSelected());
        firewallPatternMenu.add(strictPattern);
        return firewallPatternMenu;
    }

}
