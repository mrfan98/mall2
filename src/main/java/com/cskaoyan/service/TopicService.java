package com.cskaoyan.service;

import com.cskaoyan.bean.Topic;
import com.cskaoyan.bean.TopicExample;
import com.cskaoyan.mapper.TopicMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张凡 on 2020/5/4 15:32
 */
@Service
public class TopicService {
    @Autowired
    TopicMapper topicMapper;
    public List<Topic> queryList(int offset,int limit){
        TopicExample example = new TopicExample();
        example.or().andDeletedEqualTo(false);
        PageHelper.startPage(offset,limit);
        return topicMapper.selectByExample(example);
    }
    public List<Topic> findById(Integer id){
        TopicExample example = new TopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectByExample(example);
    }
    public List<Topic> queryRelatedList(Integer id,int offset,int limit){
        TopicExample example = new TopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        PageHelper.startPage(offset,limit);
        List<Topic> topics = topicMapper.selectByExample(example);
        return topics;
    }
    public int count(){
        TopicExample example = new TopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);

    }
}
