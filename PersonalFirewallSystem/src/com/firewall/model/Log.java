package com.firewall.model;

/**
 * 数据模型，对应数据库log表
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class Log {
    
    private int id;
    private String detailLog;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDetailLog() {
        return detailLog;
    }
    public void setDetailLog(String detailLog) {
        this.detailLog = detailLog;
    }
    
}
