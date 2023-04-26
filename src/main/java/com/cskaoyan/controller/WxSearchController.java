package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.Keyword;
import com.cskaoyan.bean.SearchHistory;
import com.cskaoyan.service.KeywordService;
import com.cskaoyan.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 张凡 on 2020/5/4 14:05
 */
@RestController
@RequestMapping("wx/search")
public class WxSearchController {
    @Autowired
    KeywordService keywordService;
    @Autowired
    SearchHistoryService searchHistoryService;
    @GetMapping("/index")
    public BaseRespVo index(Integer userId){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        List<Keyword> keywords = keywordService.queryDefault();
        Keyword defaultKeyword = keywords.get(0);
        List<Keyword> hotKeywordList = keywordService.queryHots();
        HashMap<String, Object> map = new HashMap<>();
        if(userId!=null) {
            List<SearchHistory> historyList = searchHistoryService.queryByUid(userId);
            map.put("historyKeywordList", historyList);
        }else{
            map.put("historyKeywordList", Collections.emptyList());
        }
        map.put("defaultKeyword",defaultKeyword);

        map.put("hotKeywordList",hotKeywordList);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @GetMapping("/helper")
    public BaseRespVo helper(String keyword){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        List<Keyword> keywordList = keywordService.queryByKeyword(keyword);
        String[] keys = new String[keywordList.size()];
        int index=0;
        for (Keyword key : keywordList) {
            keys[index++] = key.getKeyword();
        }
        baseRespVo.setData(keys);
        return baseRespVo;
    }
    @PostMapping("/clearhistory")
    public BaseRespVo clearhistory(@RequestBody Integer userId){
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        searchHistoryService.deleteByUid(userId);
        return baseRespVo;
    }
}
