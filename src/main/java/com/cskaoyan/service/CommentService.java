package com.cskaoyan.service;

import com.cskaoyan.bean.Comment;
import com.cskaoyan.bean.CommentExample;
import com.cskaoyan.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张凡 on 2020/5/4 11:18
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public int count(Byte type,Integer valueId,Integer showType){
        CommentExample example = new CommentExample();
        if(showType==0){
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        }else if(showType==1){
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);

        }
        return (int) commentMapper.countByExample(example);
    }
    public List<Comment> query(Byte type,Integer valueId,Integer showType,Integer offset,Integer limit){
        CommentExample example = new CommentExample();
        if(showType==0){
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        }else if(showType==1){
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        }
        PageHelper.startPage(offset,limit);
        return commentMapper.selectByExample(example);
    }
}
