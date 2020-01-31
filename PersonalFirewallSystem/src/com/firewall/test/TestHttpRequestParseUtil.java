package com.firewall.test;

import org.junit.jupiter.api.Test;

import com.firewall.util.HttpRequestParseUtil;

/**
 * 测试从Http请求报文中解析主机是否正确
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestHttpRequestParseUtil {
    
    // 测试对http请求报文Host解析
    @Test
    public void TestgetHost() {
        String httpRequest = "GET http://www.ncu.edu.cn/ HTTP/1.1\r\n"
                + "Cache-Control: max-age=0\r\n"
                + "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134\r\n"
                + "Accept-Language: zh-CN\r\n"
                + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n"
                + "Upgrade-Insecure-Requests: 1\r\n"
                + "Accept-Encoding: gzip, deflate\r\n"
                + "If-Modified-Since: Tue, 19 Feb 2019 01:52:30 GMT\r\n"
                + "If-None-Match: W/\"043ccc5f5c7d41:0\"\r\n"
                + "Host: www.ncu.edu.cn\r\n"
                + "Proxy-Connection: Keep-Alive\r\n"
                + "Cookie:  _pk_id.22.23e6=aa35d1760fee2882.1554268723.3.1555439203.1550795666.; _pk_ses.22.23e6=*\r\n\r\n";
        String host = HttpRequestParseUtil.getHost(httpRequest);
        System.out.print(httpRequest);
        System.out.print(host);
    }
}
