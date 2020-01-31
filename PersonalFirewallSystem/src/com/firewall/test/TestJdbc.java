package com.firewall.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.firewall.util.JdbcUtil;

/**
 * JUnit单元测试类
 * 测试能否正常访问数据库：连接，对表记录增、删、改、查操作，断开
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 */
public class TestJdbc {

    @Test
    public void testJdbcUtil() {
        // 连接数据库
        Connection con = JdbcUtil.getConnection();
        if (con != null) {
            System.out.println("连接数据库成功");
        }
        PreparedStatement preStat = null;
        ResultSet resultSet = null;
        String sql = null;
        int affectedRowCount = 0;
        try {
            // 查
            sql = "select * from website";
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                System.out.print("id = " + resultSet.getInt("id"));
                System.out.println("\twebsite_name = " + resultSet.getString("website_name"));
            }
            preStat.close();
            resultSet.close();
            
            // 增
            sql = "insert into website values(null, ?)";
            preStat = con.prepareStatement(sql);
            preStat.setString(1, "www.jxeea.cn");
            affectedRowCount = preStat.executeUpdate();
            if (affectedRowCount > 0) {
                System.out.println("插入成功");
            }
            preStat.close();
            
            // 查
            sql = "select * from website";
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                System.out.print("id = " + resultSet.getInt("id"));
                System.out.println("\twebsite_name = " + resultSet.getString("website_name"));
            }
            preStat.close();
            resultSet.close();
                    
            // 改
            sql = "update website set website_name=? where website_name=?";
            preStat = con.prepareStatement(sql);
            // 新值
            preStat.setString(1, "www.jxeea.com");
            // 旧值
            preStat.setString(2, "www.jxeea.cn");
            affectedRowCount = preStat.executeUpdate();
            if (affectedRowCount > 0) {
                System.out.println("修改成功");
            }
            preStat.close();
            
            // 查
            sql = "select * from website";
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                System.out.print("id = " + resultSet.getInt("id"));
                System.out.println("\twebsite_name = " + resultSet.getString("website_name"));
            }
            preStat.close();
            resultSet.close();
            
            // 删
            sql = "delete from website where website_name = ?";
            preStat = con.prepareStatement(sql);
            preStat.setString(1, "www.jxeea.com");
            affectedRowCount = preStat.executeUpdate();
            if (affectedRowCount > 0) {
                System.out.println("删除成功");
            }
            preStat.close();
            
            // 查
            sql = "select * from website";
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                System.out.print("id = " + resultSet.getInt("id"));
                System.out.println("\twebsite_name = " + resultSet.getString("website_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放数据库资源
            JdbcUtil.close(resultSet, preStat, con);
        }
    }
    
}
