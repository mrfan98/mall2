package com.cskaoyan.mytest;

import com.cskaoyan.utils.Md5Util;
import org.junit.jupiter.api.Test;

/**
 * Created by 张凡 on 2020/4/25 19:59
 */

public class Md5Test {
    @Test
    public void mytest() throws Exception {
        String result1 = Md5Util.getMd5("123456");
        String result2 = Md5Util.getMd5("123456");
        System.out.println(result1);

    }
}
