package com.firewall.dao;

import java.util.List;

import com.firewall.model.Website;

/**
 * 访问数据库website表接口
 * 定义了增、删、改、查的方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public interface WebsiteDAO {
    // 增
    /**
     * 通过提供网站域名来插入一条网站记录
     * @param website
     * @return
     */
    public abstract boolean add(String websiteName);
    
    // 删
    /**
     * 根据网站域名删除记录
     * @param websiteName
     * @return
     */
    public abstract boolean delete(String websiteName);
    
    // 改
    /**
     * 通过提供要修改的网站域名和新的网站域名来修改网站域名
     * @param oldValue
     * @param newValue
     * @return
     */
    public abstract boolean update(String oldValue, String newValue);
    
    // 查
    /**
     * 查找所有网站记录
     * @return
     */
    public abstract List<Website> findAll();
}
