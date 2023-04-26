package com.cskaoyan.utils;


import com.cskaoyan.bean.Storage;
import com.cskaoyan.service.StorageService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

/**
 * Created by 张凡 on 2020/5/1 18:11
 */
@Data
@Configuration
public class StorageServiceUtils {
    private String active;
    private Storages storages;
    @Autowired
    StorageService storageService;
    public Storage store(InputStream inputStream,long contentLength,String contentType,String fileName){
        String key=generateKey(fileName);
        storages.store(inputStream,contentLength,contentType,key);
        String url=generateUrl(key);
        Storage storageInfo = new Storage();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        storageService.add(storageInfo);
        return storageInfo;
    }

    private String generateUrl(String keyName) {
        return storages.generateUrl(keyName);
    }

    private String generateKey(String originalFilename) {
        int index=originalFilename.lastIndexOf('.');
        String suffix=originalFilename.substring(index);
        String key=null;
        Storage storageInfo=null;
        do{
            key=CharUtil.getRandomString(20)+suffix;
            storageInfo=storageService.findByKey(key);
        }
        while(storageInfo!=null);
        return key;
    }

}
