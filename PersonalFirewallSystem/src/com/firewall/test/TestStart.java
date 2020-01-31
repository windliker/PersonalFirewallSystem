package com.firewall.test;

import org.junit.jupiter.api.Test;

import com.firewall.ui.Start;

/**
 * 测试整个程序
 * @version 1.0.0 2019年4月3日
 * @author liukailiang
 *
 */
public class TestStart {

    @Test
    public void testMain() {
        Start.main(null);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
