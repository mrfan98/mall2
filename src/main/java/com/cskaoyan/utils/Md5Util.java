package com.cskaoyan.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 张凡 on 2020/4/25 19:47
 */

public class Md5Util {
    public static String getMd5(String content) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        byte[] contentBytes = content.getBytes();
        byte[] resultBytes = messageDigest.digest(contentBytes);
        int length = resultBytes.length;
        System.out.println("length:"+length);
        StringBuffer stringBuffer = new StringBuffer();
        for (byte resultByte : resultBytes) {
            int temp=resultByte&0xff;
            String s = Integer.toHexString(temp);
            if(s.length()==1){
                stringBuffer.append(0);
            }
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
