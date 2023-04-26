package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.Region;
import com.cskaoyan.bean.RegionVo;
import com.cskaoyan.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 张凡 on 2020/5/3 14:08
 */
@RestController
@RequestMapping("admin/region")
public class AdminRegionController {
    @Autowired
    RegionService regionService;
    @GetMapping("/list")
    public BaseRespVo list(){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List<RegionVo> regionVoList = new ArrayList<>();
        List<Region> regions = regionService.getAll();
        Map<Byte, List<Region>> collect = regions.stream().collect(Collectors.groupingBy(Region::getType));
        byte provinceType=1;
        List<Region> provinceList = collect.get(provinceType);
        byte cityType=2;
        List<Region> city = collect.get(cityType);
        Map<Integer, List<Region>> cityListMap = city.stream().collect(Collectors.groupingBy(Region::getPid));
        byte areaType=3;
        List<Region> areas = collect.get(areaType);
        Map<Integer, List<Region>> areaListMap = areas.stream().collect(Collectors.groupingBy(Region::getPid));
        for (Region province : provinceList) {
            RegionVo provinceVo = new RegionVo();
            provinceVo.setId(province.getId());
            provinceVo.setName(province.getName());
            provinceVo.setCode(province.getCode());
            provinceVo.setType(province.getType());
            List<Region> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVoList = new ArrayList<>();
            for (Region cityVo : cityList) {
              RegionVo cityVO = new RegionVo();
              cityVO.setId(cityVo.getId());
              cityVO.setName(cityVo.getName());
              cityVO.setCode(cityVo.getCode());
              cityVO.setType(cityVo.getType());
                List<Region> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (Region area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }
                cityVO.setChildren(areaVOList);
                cityVoList.add(cityVO);

            }
            provinceVo.setChildren(cityVoList);
            regionVoList.add(provinceVo);
        }
        baseRespVo.setData(regionVoList);
        return baseRespVo;
    }
}
