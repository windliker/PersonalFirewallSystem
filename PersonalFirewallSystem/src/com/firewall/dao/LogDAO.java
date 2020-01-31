package com.firewall.dao;

import java.util.List;

import com.firewall.model.Log;

/**
 * 访问数据库log表的接口
 * 定义了增加日志、清空日志表、查找所有日志记录的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface LogDAO {

    // 增
    /**
     * 增加一条日志记录
     * @param logItem
     * @return
     */
    public boolean add(String logItem);
    
    // 删
    /**
     * 清空log表
     * @return
     */
    public void empty();
    
    // 查
    /**
     * 查找log表所有记录
     * @return
     */
    public List<Log> findAll();
    
    // 数据库分页查找
}
 