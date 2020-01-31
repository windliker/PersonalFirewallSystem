package com.firewall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.firewall.dao.LogDAO;
import com.firewall.model.Log;
import com.firewall.util.JdbcUtil;

/**
 * LogDAO接口的实现类
 * 重写了接口中所有方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class LogDAOImpl implements LogDAO {

    @Override
    public boolean add(String logItem) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into log values (null, ?)";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, logItem);
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
    public void empty() {
        Connection con = JdbcUtil.getConnection();
        String sql = "truncate table log";  // DDL语句无返回值
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.executeUpdate();    // 返回0
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(preStat, con);
        }
    }

    @Override
    public List<Log> findAll() {
        List<Log> logs = new ArrayList<Log>();
        Connection con = JdbcUtil.getConnection();
        String sql = "select * from log";
        PreparedStatement preStat = null;
        ResultSet resultSet = null;
        try {
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                Log log = new Log();
                log.setId(resultSet.getInt("id"));
                log.setDetailLog(resultSet.getString("detail_log"));
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, preStat, con);
        }
        return logs;
    }
}
