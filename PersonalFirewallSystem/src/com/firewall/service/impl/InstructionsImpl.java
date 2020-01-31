package com.firewall.service.impl;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;

import com.firewall.action.InstructionsAction;
import com.firewall.service.Instructions;
import com.firewall.util.GlobalConsts;

/**
 * 帮助菜单的实现
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class InstructionsImpl implements Instructions {
    
    // 使用说明菜单项的配置
    private void helpUseConfigure(Container contentPane) {
        helpUse.setText(GlobalConsts.MENUITEM_HELP_USE);
        helpUse.setFont(GlobalConsts.WINDOW_FONT);
        helpUse.addActionListener(event -> {
            InstructionsAction helpMenu = new InstructionsAction();
            helpMenu.handleHelpUse(contentPane);
        });
    }
    
    // 关于（系统介绍）菜单项的配置
    private void aboutConfigure(JFrame frame) {
        about.setText(GlobalConsts.MENUITEM_ABOUT);
        about.setFont(GlobalConsts.WINDOW_FONT);
        about.addActionListener(event -> {
            InstructionsAction helpMenu = new InstructionsAction();
            helpMenu.handleIntroduction(frame);
        });
    }

    // 帮助菜单的配置
    @Override
    public JMenu helpMenuConfigure(JFrame frame, Container contentPane) {
        helpMenu.setText(GlobalConsts.MENU_HELP);
        helpMenu.setFont(GlobalConsts.WINDOW_FONT);
        helpUseConfigure(contentPane);
        aboutConfigure(frame);
        helpMenu.add(helpUse);
        helpMenu.add(about);
        return helpMenu;
    }
}
