package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.Region;
import com.cskaoyan.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 张凡 on 2020/5/3 16:24
 */
@RestController
public class WxRegionController {
    @Autowired
    RegionService regionService;
    @GetMapping("wx/region/list")
    public BaseRespVo list1(Integer pid){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List<Region> regions = regionService.getByPid(pid);
        baseRespVo.setData(regions);
        return baseRespVo;
    }

}
