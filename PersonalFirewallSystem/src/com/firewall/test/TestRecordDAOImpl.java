package com.firewall.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.firewall.dao.RecordDAO;
import com.firewall.dao.impl.RecordDAOImpl;
import com.firewall.model.Record;

/**
 * 测试RecordDAOImpl中的所有public方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestRecordDAOImpl {
    @Test
    public void testAdd() {
        RecordDAO recordDAO = new RecordDAOImpl();
        if (recordDAO.add("插入测试")) {
            System.out.println("testAdd测试通过");
        }   
    }
    
    @Test
    public void testFindAll() {
        RecordDAO recordDAO = new RecordDAOImpl();
        List<Record> records = recordDAO.findAll();
        for (Record record : records) {
            System.out.print(record.getId() + " ");
            System.out.println(record.getRejectRecord());
        }
    }
    
    @Test
    public void testEmpty() {
        RecordDAO recordDAO = new RecordDAOImpl();
        recordDAO.empty();
    }

}
