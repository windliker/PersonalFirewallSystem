package com.firewall.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

import com.firewall.dao.LogDAO;
import com.firewall.dao.impl.LogDAOImpl;

/**
 * 生成日志的工具类
 * 提供获取系统当前时间戳的静态方法和写日志的静态方法
 * @version 1.0.0 2019年4月22日
 * @author liukailiang
 *
 */
public class WriteLogUtil {

    private WriteLogUtil() {}
    
    /**
     * 获取系统当前时间戳
     * @return
     */
    public static synchronized String getTimeStamp() {
        String timeStamp;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        timeStamp = dateFormat.format(new Date());
        return timeStamp;
    }
    
    /**
     * 添加一条通信连接记录至 实时文本域的首行并写入数据库日志表
     * @param textArea
     * @param log
     * @param logItem
     */
    public static synchronized void writeLog(JTextArea textArea, String logItem) { 
        if (textArea.getLineCount() > 300) {
            textArea.setText("");
        }
        textArea.insert(logItem, 0);
        
        LogDAO logDAO = new LogDAOImpl();
        logDAO.add(logItem);
    }
}
