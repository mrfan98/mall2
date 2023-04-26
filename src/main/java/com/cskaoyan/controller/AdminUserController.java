package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.User;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhang fan
 * @date 2021/5/17 22:51
 */
@RestController
@RequestMapping("admin")
public class AdminUserController {
    @Autowired
    UserService userService;
    @GetMapping("user/list")
    public BaseRespVo userList(Integer page,Integer limit,String sort,String order){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map<String, Object> map = userService.listUser(page, limit);
        baseRespVo.setData(map);
        return baseRespVo;


    }
}

