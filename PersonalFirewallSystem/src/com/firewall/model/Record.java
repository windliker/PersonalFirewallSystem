package com.firewall.model;

/**
 * 数据模型，对应数据库record表
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class Record {

    private int id;
    private String rejectRecord;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRejectRecord() {
        return rejectRecord;
    }
    public void setRejectRecord(String rejectRecord) {
        this.rejectRecord = rejectRecord;
    }

}
