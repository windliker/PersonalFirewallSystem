package com.firewall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.firewall.dao.WebsiteDAO;
import com.firewall.model.Website;
import com.firewall.util.JdbcUtil;

/**
 * WebsiteDAO接口的实现类
 * 重写了接口中所有的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class WebsiteDAOImpl implements WebsiteDAO {
    
    @Override
    public boolean add(String websiteName) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into website values(null, ?)";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, websiteName);
            if (preStat.executeUpdate() > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(preStat, con);
        }
        return status;
    }

    @Override
    public boolean delete(String websiteName) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "delete from website where website_name = ?";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, websiteName);
            if (preStat.executeUpdate() > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(preStat, con);
        }
        return status;
    }

    @Override
    public boolean update(String oldValue, String newValue) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "update website set website_name = ? where "
                + "website_name = ?";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, newValue);
            preStat.setString(2, oldValue);
            if (preStat.executeUpdate() > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(preStat, con);
        }
        return status;
    }

    @Override
    public List<Website> findAll() {
        List<Website> websites = new ArrayList<Website>();     
        Connection con = JdbcUtil.getConnection();
        String sql = "select * from website";
        PreparedStatement preStat = null;
        ResultSet resultSet = null;
        try {
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                Website website = new Website();
                website.setId(resultSet.getInt("id"));
                website.setWebsiteName(resultSet.getString("website_name"));
                websites.add(website);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, preStat, con);
        }
        
        return websites;
    }
}
