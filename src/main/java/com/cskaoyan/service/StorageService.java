package com.cskaoyan.service;

import com.cskaoyan.bean.Storage;
import com.cskaoyan.bean.StorageExample;
import com.cskaoyan.mapper.StorageMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by 张凡 on 2020/5/1 12:21
 */
@Service
public class StorageService {
    @Autowired
    StorageMapper storageMapper;
    public List<Storage> querySelective(String key,String name,Integer page,Integer limit,String sort,String order){
        StorageExample example = new StorageExample();
        StorageExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(key)){
            criteria.andKeyEqualTo(key);
        }
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        criteria.andDeletedEqualTo(false);
        if(!StringUtils.isEmpty(sort)&& !StringUtils.isEmpty(order)){
            example.setOrderByClause(sort+" "+order);
        }
        PageHelper.startPage(page,limit);
        return storageMapper.selectByExample(example);
    }
    public void add(Storage storageInfo){
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }
    public Storage findByKey(String key){
        StorageExample example = new StorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return (Storage) storageMapper.selectByExample(example);
    }
    public void deleteByKey(String key){
        StorageExample example = new StorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.deleteByExample(example);
    }
    public int update(Storage storageInfo){
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }
    public Storage findById(Storage storageInfo){
        Integer id = storageInfo.getId();
        Storage storage = storageMapper.selectByPrimaryKey(id);
        return storage;
    }
}
