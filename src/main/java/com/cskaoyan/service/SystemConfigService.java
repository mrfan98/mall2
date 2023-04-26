package com.cskaoyan.service;


import com.cskaoyan.bean.System;
import com.cskaoyan.bean.SystemExample;
import com.cskaoyan.mapper.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张凡 on 2020/4/29 22:44
 */
@Service
public class SystemConfigService {
    @Autowired
    SystemMapper systemMapper;
    public Map<String,Object> listMall(){
        SystemExample example = new SystemExample();
        example.or().andKeyNameLike("cskaoyan_mall_mall_%").andDeletedEqualTo(false);
        List<System> systems = systemMapper.selectByExample(example);
        HashMap<String, Object> map = new HashMap<>();
        for (System system : systems) {
            map.put(system.getKeyName(),system.getKeyValue());
        }
        return map;
    }
    /*Map提供了一些常用方法，如keySet()、entrySet()等方法，keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
    Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。*/
    public void updateConfig(Map<String,String> data){
        for (Map.Entry<String, String> entry : data.entrySet()) {
            SystemExample example = new SystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);
            System system = new System();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
            system.setUpdateTime(dateFormat.format(date));
            systemMapper.updateByExampleSelective(system,example);
        }
    }
    public void updateWx(Map<String,Object> map){
        SystemExample example = new SystemExample();
        example.or().andKeyNameLike("cskaoyan_mall_wx_%").andDeletedEqualTo(false);


    }
    public Map<String,String> listExpress(){
        SystemExample example = new SystemExample();
        example.or().andKeyNameLike("cskaoyan_mall_express_%").andDeletedEqualTo(false);
        List<System> systems = systemMapper.selectByExample(example);
        HashMap<String, String> map = new HashMap<>();
        for (System system : systems) {
            map.put(system.getKeyName(),system.getKeyValue());
        }
        return map;
    }
    public Map<String,String> listOrder(){
        SystemExample example = new SystemExample();
        example.or().andKeyNameLike("cskaoyan_mall_order_%").andDeletedEqualTo(false);
        List<System> systems = systemMapper.selectByExample(example);
        HashMap<String,String> map = new HashMap<>();
        for (System system : systems) {
            map.put(system.getKeyName(),system.getKeyValue());
        }
        return map;
    }
    public Map<String,String> listWx(){
        SystemExample example = new SystemExample();
        example.or().andKeyNameLike("cskaoyan_mall_wx_%").andDeletedEqualTo(false);
        List<System> systems = systemMapper.selectByExample(example);
        HashMap<String,String> map = new HashMap<>();
        for (System system : systems) {
            map.put(system.getKeyName(),system.getKeyValue());
        }
        return map;
    }




}
