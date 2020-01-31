package com.firewall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.firewall.dao.RecordDAO;
import com.firewall.model.Record;
import com.firewall.util.JdbcUtil;

/**
 * RecordDAO接口的实现类
 * 重写了接口中所有的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class RecordDAOImpl implements RecordDAO {

    @Override
    public boolean add(String rejectRecord) {
        boolean status = false;
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into record values(null, ?)";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.setString(1, rejectRecord);
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
        String sql = "truncate table record";
        PreparedStatement preStat = null;
        try {
            preStat = con.prepareStatement(sql);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(preStat, con);
        }
    }

    @Override
    public List<Record> findAll() {
        List<Record> records = new ArrayList<Record>();
        Connection con = JdbcUtil.getConnection();
        String sql = "select * from record";
        PreparedStatement preStat = null;
        ResultSet resultSet = null;
        try {
            preStat = con.prepareStatement(sql);
            resultSet = preStat.executeQuery();
            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setRejectRecord(resultSet.getString("reject_record"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, preStat, con);
        }
        return records;
    }
}
