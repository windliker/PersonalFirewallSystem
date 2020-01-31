package com.firewall.model;

/**
 * 数据模型，对应数据库website表
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class Website {

    private int id;
    private String websiteName;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWebsiteName() {
        return websiteName;
    }
    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }
    
}
