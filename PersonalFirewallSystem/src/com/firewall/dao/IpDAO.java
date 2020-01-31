package com.firewall.dao;

import java.util.List;

import com.firewall.model.Ip;

/**
 * 访问数据库ip表的接口
 * 定义了增、删、改、查的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface IpDAO {
    // 增
    /**
     * 通过提供ip地址来插入一条ip记录
     * @param ipAddr
     * @return
     */
    public boolean add(String ipAddr);
    
    // 删
    /**
     * 根据ip地址删除记录
     * @param ipAddr
     * @return
     */
    public boolean delete(String ipAddr);
    
    // 改
    /**
     * 通过提供要修改的ip地址和新的ip地址来修改ip地址
     * @param oldVal
     * @param newVal
     * @return
     */
    public boolean update(String oldVal, String newVal);
    
    // 查
    /**
     * 查找所有ip记录
     * @return
     */
    public List<Ip> findAll();
}
