package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.service.StorageService;
import com.cskaoyan.utils.StorageServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 张凡 on 2020/5/1 12:00
 */
@RestController
@RequestMapping("admin/storage")
public class AdminStorageController {
    @Autowired
    StorageServiceUtils storageServiceUtils;
    @Autowired
    StorageService storageService;
    @GetMapping("/list")
    public BaseRespVo list( String key,String name,Integer page,Integer limit,String sort,String order){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        HashMap<String, Object> map = new HashMap<>();
        List<Storage> storages = storageService.querySelective(key, name, page, limit, sort, order);
        int total=storages.size();
        map.put("total",total);
        map.put("items",storages);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @PostMapping("/create")
    public BaseRespVo create(@RequestParam("file") MultipartFile file) throws IOException {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        String originalFilename = file.getOriginalFilename();
        Storage storage = storageServiceUtils.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
        baseRespVo.setData(storage);
        return baseRespVo;
    }
    @PostMapping("/delete")
    public BaseRespVo delete(@RequestBody Storage storage){
        String key = storage.getKey();
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        storageService.deleteByKey(key);
        return baseRespVo;
    }
    @PostMapping("/update")
    public BaseRespVo update(@RequestBody Storage storageInfo){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        storageService.update(storageInfo);
        HashMap<String, Object> map = new HashMap<>();
        Storage storage = storageService.findById(storageInfo);
        map.put("data",storage);
        baseRespVo.setData(map);
        return baseRespVo;
    }
}
