package com.firewall.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.firewall.dao.LogDAO;
import com.firewall.dao.impl.LogDAOImpl;
import com.firewall.model.Log;

/**
 * 测试LogDAOImpl中的所有public方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestLogDAOImpl {
    @Test
    public void testAdd() {
        LogDAO logDAO = new LogDAOImpl();
        if (logDAO.add("插入测试")) {
            System.out.println("testAdd测试通过");
        }
    }
    
    @Test
    public void findAll() {
        LogDAO logDAO = new LogDAOImpl();
        List<Log> logs = logDAO.findAll();
        for (Log log : logs) {
            System.out.print(log.getId() + " ");
            System.out.println(log.getDetailLog());
        }
    }
    
    @Test
    public void testEmpty() {
        LogDAO logDAO = new LogDAOImpl();
        logDAO.empty();
    }

}
