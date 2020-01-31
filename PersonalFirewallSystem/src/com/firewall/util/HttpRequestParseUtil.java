package com.firewall.util;

//解析字符串形式的Http请求报文，提取出首部域head fieds中Host字段的值
/**
 * Http请求报文解析工具类
 * 使用一个静态同步方法解析出所请求的主机名
 * @version 1.0.0 2019年4月22日
 * @author liukailiang
 *
 */
public class HttpRequestParseUtil {

    private HttpRequestParseUtil() {}
    
    // 获取请求的主机名
    public static synchronized String getHost(String httpRequest) {
        String host = null;
        String pattern = "\r\nHost: ";
        // 获得字符串"\r\nHost: " 首字符\r偏离主串首字符的位置
        int offset = httpRequest.indexOf(pattern);
        // Host字段对应值的起始字符位置
        int begin = offset + pattern.length();
        // Host字段对应值后一字符的位置
        int end = httpRequest.indexOf('\r', begin);
        // 从字符串形式的请求报文中提取出Host字段的值
        host = httpRequest.substring(begin, end);
        return host;
    }

}
