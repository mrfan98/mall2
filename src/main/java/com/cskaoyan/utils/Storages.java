package com.cskaoyan.utils;

import java.io.InputStream;

/**
 * Created by 张凡 on 2020/5/1 19:57
 */

public interface Storages {
    void store(InputStream inputStream,long contentLength,String contentType,String keyName);
    String generateUrl(String keyName);

}
