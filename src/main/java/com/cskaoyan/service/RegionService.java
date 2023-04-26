package com.cskaoyan.service;

import com.cskaoyan.bean.Region;
import com.cskaoyan.bean.RegionExample;
import com.cskaoyan.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张凡 on 2020/5/3 14:18
 */
@Service
public class RegionService {
    @Autowired
    RegionMapper regionMapper;
    public List<Region> getAll(){
        RegionExample example = new RegionExample();
        byte b=4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }
    public List<Region> getByPid(Integer pid){
        RegionExample example = new RegionExample();
        example.or().andPidEqualTo(pid);
        return regionMapper.selectByExample(example);
    }
}
