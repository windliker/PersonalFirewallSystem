package com.firewall.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.firewall.dao.WebsiteDAO;
import com.firewall.dao.impl.WebsiteDAOImpl;
import com.firewall.model.Website;

/**
 * 测试IpDAOImpl中的所有public方法
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestWebsiteDAOImpl {
    @Test
    public void testAdd() {
        WebsiteDAO websiteDAO = new WebsiteDAOImpl();
        if (websiteDAO.add("www.jxeea.cn")) {
            System.out.println("testAdd测试通过");
        }
    }
    
    @Test
    public void testUpdate() {
        WebsiteDAO websiteDAO = new WebsiteDAOImpl();
        if (websiteDAO.update("www.jxeea.cn", "www.jxeea.com")) {
            System.out.println("testUpdate测试通过");
        }
    }
    
    @Test
    public void testFindAll() {
        WebsiteDAO websiteDAO = new WebsiteDAOImpl();
        List<Website> websites = websiteDAO.findAll();
        for (Website website : websites) {
            System.out.print(website.getId() + " ");
            System.out.println(website.getWebsiteName());
        }
    }
    
    @Test
    public void testDelete() {
        WebsiteDAO websiteDAO = new WebsiteDAOImpl();
        if (websiteDAO.delete("www.jxeea.com")) {
            System.out.println("testDelete测试通过");
        }
    }
}
