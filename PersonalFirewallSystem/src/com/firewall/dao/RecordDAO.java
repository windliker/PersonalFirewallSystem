package com.firewall.dao;

import java.util.List;

import com.firewall.model.Record;

/**
 * 访问数据库record表的接口
 * 定义了增加拦截记录、清空拦截记录表、查找表中所有记录的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface RecordDAO {

    // 增
    /**
     * 增加一条拦截记录
     * @param rejectRecord
     * @return
     */
    boolean add(String rejectRecord);
    
    // 删
    /**
     * 清空拦截记录表
     */
    void empty();
    
    // 查
    /**
     * 查找所有拦截记录表所有记录
     * @return
     */
    List<Record> findAll();
    
    // 数据库分页查找
}
