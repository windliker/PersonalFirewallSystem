package com.firewall.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 与数据库连接相关的工具类，类中成员都是静态的
 * 提供获取数据库连接对象的方法
 * 提供重载的释放数据库连接资源的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class JdbcUtil {

    private static String url = null;
    private static String user = null;
    private static String password = null;
    
    /**
     * 类一加载进内存，就读取项目根目录下的连接数据库的属性配置文件中的属性：url, user, password
     */
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * 私有化无参构造器，禁止实例化该类
     */
    private JdbcUtil() {}
    
    /**
     * 获取数据库连接对象
     * @return con
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return con;
    }

    /**
     * 释放数据库连接资源
     * @param preStat
     * @param con
     */
    public static void close(PreparedStatement preStat, Connection con) {
        closePreStat(preStat);
        closeCon(con);
    }
    
    /**
     * 释放数据库连接资源
     * @param resultSet
     * @param preStat
     * @param con
     */
    public static void close(ResultSet resultSet, PreparedStatement preStat,
            Connection con) {
        closeResultSet(resultSet);
        close(preStat, con);
    }
    
    /**
     * 释放结果集对象的数据库和jdbc资源
     * @param resultSet
     */
    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
        }
    }
    
    /**
     * 释放preparedstatement对象的数据库和jdbc资源
     * @param preStat
     */
    private static void closePreStat(PreparedStatement preStat) {
        try {
            if (preStat != null) {
                preStat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preStat = null;
        }
    }
    
    /**
     * 释放Connection对象的数据库和jdbc资源
     * @param con
     */
    private static void closeCon(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null;
        }
    }
}
