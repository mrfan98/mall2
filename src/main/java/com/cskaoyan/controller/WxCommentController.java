package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.Comment;
import com.cskaoyan.bean.UserInfo;
import com.cskaoyan.service.CommentService;
import com.cskaoyan.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张凡 on 2020/5/4 11:06
 */
@RestController
@RequestMapping("wx/comment")
public class WxCommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserInfoService userInfoService;
    @GetMapping("/count")
    public BaseRespVo count(Byte type,Integer valueId){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        int allCount=commentService.count(type,valueId,0);
        int hasPicCount=commentService.count(type,valueId,1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("allCount",allCount);
        map.put("hasPicCount",hasPicCount);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @GetMapping("/list")
    public BaseRespVo list( Byte type,Integer valueId,Integer showType,Integer page,Integer size){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List<Comment> commentList = commentService.query(type, valueId, showType, page, size);
        List<Map<String,Object>> commentVoList = new ArrayList<>(commentList.size());
        for (Comment comment : commentList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("addTime",comment.getAddTime());
            map.put("content",comment.getContent());
            map.put("picList",comment.getPicUrls());
            UserInfo userInfo = userInfoService.getInfo(comment.getUserId());
            map.put("userInfo",userInfo);
            commentVoList.add(map);
        }
        baseRespVo.setData(commentVoList);
        return baseRespVo;
    }

}
