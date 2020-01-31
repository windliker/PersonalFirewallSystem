package com.firewall.model;

/**
 * 数据模型，对应数据库ip表
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class Ip {
    
    private int id;
    private String ipAddress;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
}
