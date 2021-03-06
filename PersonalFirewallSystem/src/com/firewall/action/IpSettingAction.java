package com.firewall.action;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.firewall.dao.IpDAO;
import com.firewall.dao.impl.IpDAOImpl;
import com.firewall.model.Ip;

/**
 * 黑（白）名单ip菜单事件处理
 * 增、删、改、查
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class IpSettingAction {
    
    public IpSettingAction() {}
    
    public void handleAdd(Container contentPane) {
        // 清空窗口的内容窗格
        contentPane.removeAll();
        JPanel mainPane = new JPanel();
        JLabel noticeLabel = new JLabel("输入IP地址：");
        JTextField inputField = new JTextField(20);
        JButton saveBtn = new JButton("添加");
        saveBtn.addActionListener(event -> {
            String ipAddr = inputField.getText();
            IpDAO ipDAO = new IpDAOImpl();
            // 未对输入的ip地址做正确性和重复性检查
            if (ipDAO.add(ipAddr)) {
                JOptionPane.showMessageDialog(mainPane, "添加成功");
            }
            inputField.setText("");
        });
        mainPane.add(noticeLabel);
        mainPane.add(inputField);
        mainPane.add(saveBtn);
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.validate();
    }
    
    public void handleDelete(Container contentPane) {
        contentPane.removeAll();
        JPanel mainPane = new JPanel();
        JLabel noticeLabel = new JLabel("请输入要删除的IP地址：");
        JTextField inputField = new JTextField(20);
        JButton deleteBtn= new JButton("删除");
        deleteBtn.addActionListener(event -> {
            String ipAddr = inputField.getText();
            IpDAO ipDAO = new IpDAOImpl();
            if (ipDAO.delete(ipAddr)) {
                JOptionPane.showMessageDialog(mainPane, "删除成功");
            }
            inputField.setText("");
        });
        mainPane.add(noticeLabel);
        mainPane.add(inputField);
        mainPane.add(deleteBtn);
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.validate();

    }
    
    public void handleUpdate(Container contentPane) {
        contentPane.removeAll();
        JPanel mainPane = new JPanel();
        // 提示 输入旧值
        // 提示 输入新值
        // 确定
        JLabel noticeLabel1 = new JLabel("请输入要修改的IP地址： ");
        JTextField inputField1 = new JTextField(20);
        JLabel noticeLabel2 = new JLabel("请输入新的IP地址： ");
        JTextField inputField2 = new JTextField(20);
        JButton confirmBtn = new JButton("修改");
        confirmBtn.addActionListener(event -> {
            String oldVal = inputField1.getText();
            String newVal = inputField2.getText();
            IpDAO ipDAO = new IpDAOImpl();
            if (ipDAO.update(oldVal, newVal)) {
                JOptionPane.showMessageDialog(mainPane, "修改成功");
            }
            inputField1.setText("");
            inputField2.setText("");
        });
        mainPane.add(noticeLabel1);
        mainPane.add(inputField1);
        mainPane.add(noticeLabel2);
        mainPane.add(inputField2);
        mainPane.add(confirmBtn);
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.validate();    
    }
    
    public void handleInquiry(Container contentPane) {
        contentPane.removeAll();
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());
        // 表格
        Object[] columnNames = {"序号", "IP地址"};
        IpDAO ipDAO = new IpDAOImpl();
        List<Ip> ips = ipDAO.findAll();
        Object[][] rowData = new Object[ips.size()][columnNames.length];
        for (int i = 0; i < rowData.length; i++) {
            rowData[i][0] = i + 1;
            rowData[i][1] = ips.get(i).getIpAddress();
        }
        JTable ipTable = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(ipTable);
        mainPane.add(scrollPane);
        contentPane.add(mainPane, BorderLayout.CENTER);
        contentPane.validate();
    }

}
