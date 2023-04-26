package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张凡 on 2020/4/24 9:18
 */
@RestController
public class AdminController {
    @RequestMapping("admin/auth/login")
    public BaseRespVo login(@RequestBody  Map map){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setData("f31bf3a7-f4ae-4747-b44d-c83340b83c35");
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
    @RequestMapping("admin/auth/info")
    public BaseRespVo info(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","admin123");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ArrayList<String> roleList = new ArrayList<>();
        roleList.add("超级管理员");
        ArrayList<String> permList = new ArrayList<>();
        permList.add("*");
        map.put("roles",roleList);
        map.put("perms",permList);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @RequestMapping("/admin/dashboard")
    public String dashboard(){
        return "{\"timestamp\":\"2020-04-29T03:43:01.945+0000\",\"status\":404,\"error\":\"Not Found\",\"message\":\"No message available\",\"path\":\"/admin/dashboard\"}";
    }
}
