package com.cskaoyan.service;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import com.cskaoyan.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张凡 on 2020/5/4 11:44
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findById(Integer userId){

        return userMapper.selectByPrimaryKey(userId);
    }
    public Map<String,Object> listUser(Integer page, Integer limit){
        UserExample userExample = new UserExample();
        userExample.or().andIdIsNull();
        userExample.setOrderByClause("add_time desc");
        PageHelper.startPage(page,limit);
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add(users);

        map.put("total",total);
        map.put("items",list);
        return map;


    }
}
