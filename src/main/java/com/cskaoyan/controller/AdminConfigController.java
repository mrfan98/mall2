package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.service.SystemConfigService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张凡 on 2020/4/29 12:34
 */
@RestController
@RequestMapping("admin/config")
public class AdminConfigController {
    @Autowired
    SystemConfigService systemConfigService;
    @GetMapping("/mall")
    public BaseRespVo mall(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map<String, Object> map = systemConfigService.listMall();
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @PostMapping("/mall")
    public BaseRespVo mallUpdate(@RequestBody Map map){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        systemConfigService.updateConfig(map);
        return baseRespVo;
    }
    @GetMapping("/express")
    public BaseRespVo express(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map<String, String> map = systemConfigService.listExpress();
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @PostMapping("/express")
    public BaseRespVo expressUpdate(@RequestBody Map map){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        systemConfigService.updateConfig(map);
        return baseRespVo;
    }
    @GetMapping("/order")
    public BaseRespVo order(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map<String, String> map = systemConfigService.listOrder();
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @PostMapping("/order")
    public BaseRespVo orderUpdate(@RequestBody Map map){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        systemConfigService.updateConfig(map);
        return baseRespVo;
    }
    @GetMapping("/wx")
    public BaseRespVo wx(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map<String, String> map = systemConfigService.listWx();
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @PostMapping("/wx")
    public BaseRespVo wxUpdate(@RequestBody Map map){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Boolean share = (Boolean) map.get("cskaoyan_mall_wx_share");
        String s = String.valueOf(share);
        map.put("cskaoyan_mall_wx_share",s);
        systemConfigService.updateConfig(map);
        return baseRespVo;
    }

}
