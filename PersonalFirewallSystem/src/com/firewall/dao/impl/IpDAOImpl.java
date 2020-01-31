package com.firewall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.firewall.dao.IpDAO;
import com.firewall.model.Ip;
import com.firewall.util.JdbcUtil;

/**
 * IpDAO接口的实现类
 * 重写了接口中所有方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class IpDAOImpl implements IpDAO {

    @Override
    public boolean add(String ipAddr) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into ip values(null, ?)";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, ipAddr);
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
    public boolean delete(String ipAddr) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "delete from ip where ip_address = ?";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, ipAddr);
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
    public boolean update(String oldVal, String newVal) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "update ip set ip_address = ? where ip_address = ?";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, newVal);
            preStat.setString(2, oldVal);
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
    public List<Ip> findAll() {
        List<Ip> ips = new ArrayList<Ip>();
        Connection con = JdbcUtil.getConnection();
        String sql = "select * from ip";
        PreparedStatement preStat = null;
        ResultSet resultSet = null;
        try {
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                Ip ip = new Ip();
                ip.setId(resultSet.getInt("id"));
                ip.setIpAddress(resultSet.getString("ip_address"));
                ips.add(ip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, preStat, con);
        }
        return ips;
    }
}
