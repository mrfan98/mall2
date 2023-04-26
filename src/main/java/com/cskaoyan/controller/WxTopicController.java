package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.Topic;
import com.cskaoyan.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 张凡 on 2020/5/4 15:08
 */
@RestController
@RequestMapping("wx/topic")
public class WxTopicController {
    @Autowired
    TopicService topicService;
    @GetMapping("/detail")
    public BaseRespVo detail(Integer id){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List<Topic> topics = topicService.findById(id);
        Topic topic = topics.get(0);
        HashMap<String, Object> map = new HashMap<>();
        List<Object> goods = new ArrayList<>();
        map.put("topic",topic);
        map.put("goods",goods);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @GetMapping("/related")
    public BaseRespVo related(Integer id){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List<Topic> topics = topicService.queryRelatedList(id, 0, 4);
        baseRespVo.setData(topics);
        return baseRespVo;
    }
    @GetMapping("/list")
    public BaseRespVo list(Integer page,Integer size){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List<Topic> topicList = topicService.queryList(page, size);
        int count = topicService.count();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",topicList);
        map.put("count",count);
        baseRespVo.setData(map);
        return baseRespVo;
    }

}
