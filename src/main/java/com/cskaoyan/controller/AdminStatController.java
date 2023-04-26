package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 张凡 on 2020/4/30 21:20
 */
@RestController
@RequestMapping("admin/stat")
public class AdminStatController {
    @GetMapping("/user")
    public String user(){
        return "{\"errno\":0,\"data\":{\"columns\":[\"day\",\"users\"],\"rows\":[{\"users\":3}]},\"errmsg\":\"成功\"}";
    }
  /*  public BaseRespVo user(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> columnList= new ArrayList<>();
        columnList.add("day");
        columnList.add("users");
        ArrayList<Object> rowList = new ArrayList<>();
        HashMap<String, Integer> rowsMap = new HashMap<>();
        rowsMap.put("users",3);
        rowList.add(rowsMap);
        map.put("columns",columnList);
        map.put("rows",rowList);
        baseRespVo.setData(map);
        return baseRespVo;
    }*/
    @GetMapping("/order")
    public String order(){
        return "{\"errno\":0,\"data\":{\"columns\":[\"day\",\"orders\",\"customers\",\"amount\",\"pcr\"],\"rows\":[{\"amount\":4989.00,\"orders\":4,\"customers\":3,\"day\":\"2020-04-27\",\"pcr\":1663.00},{\"amount\":4016.00,\"orders\":2,\"customers\":1,\"day\":\"2020-04-29\",\"pcr\":4016.00}]},\"errmsg\":\"成功\"}";

    }
    @GetMapping("/goods")
    public String goods(){
        return "{\"errno\":0,\"data\":{\"columns\":[\"day\",\"orders\",\"products\",\"amount\"],\"rows\":[{\"amount\":10319.00,\"orders\":20,\"day\":\"2020-04-27\",\"products\":20}]},\"errmsg\":\"成功\"}";
    }
}
