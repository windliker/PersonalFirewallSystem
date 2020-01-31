package com.firewall.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.firewall.dao.IpDAO;
import com.firewall.dao.impl.IpDAOImpl;
import com.firewall.model.Ip;

/**
 * 测试IpDAOImpl中的所有public方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestIpDAOImpl {
    @Test
    public void testAdd() {
        IpDAO ipDAO = new IpDAOImpl();
        if (ipDAO.add("222.204.3.221")) {
            System.out.println("testAdd通过测试");
        }
    }
    
    @Test
    public void testUpdate() {
        IpDAO ipDAO = new IpDAOImpl();
        if (ipDAO.update("222.204.3.221", "221.3.204.222")) {
            System.out.println("testUpdate通过测试");
        }
    }
    
    @Test
    public void testFindAll() {
        IpDAO ipDAO = new IpDAOImpl();
        List<Ip> ips = ipDAO.findAll();
        for (Ip ip : ips) {
            System.out.print(ip.getId() + " ");
            System.out.println(ip.getIpAddress());
        }
    }
    
    @Test
    public void testDelete() {
        IpDAO ipDAO = new IpDAOImpl();
        if (ipDAO.delete("221.3.204.222")) {
            System.out.println("testDelete通过测试");
        }
    }
}
