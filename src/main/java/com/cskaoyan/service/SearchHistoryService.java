package com.cskaoyan.service;

import com.cskaoyan.bean.SearchHistory;
import com.cskaoyan.bean.SearchHistoryExample;
import com.cskaoyan.mapper.SearchHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张凡 on 2020/5/4 14:11
 */
@Service
public class SearchHistoryService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;
    public List<SearchHistory> queryByUid(int uid){
        SearchHistoryExample example = new SearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExample(example);
    }
    public void deleteByUid(int uid){
        SearchHistoryExample example = new SearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.deleteByExample(example);
    }
}
