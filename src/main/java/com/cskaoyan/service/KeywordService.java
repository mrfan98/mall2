package com.cskaoyan.service;

import com.cskaoyan.bean.Keyword;
import com.cskaoyan.bean.KeywordExample;
import com.cskaoyan.mapper.KeywordMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 张凡 on 2020/5/4 14:10
 */
@Service
public class KeywordService {
    @Autowired
    KeywordMapper keywordMapper;
    public List<Keyword> queryDefault(){
        KeywordExample example = new KeywordExample();
        example.or().andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return  keywordMapper.selectByExample(example);
    }
    public List<Keyword> queryHots(){
        KeywordExample example = new KeywordExample();
        example.or().andIsHotEqualTo(true).andDeletedEqualTo(false);
        return keywordMapper.selectByExample(example);
    }
    public List<Keyword> queryByKeyword(String keyword){
        KeywordExample example = new KeywordExample();
        example.setDistinct(true);
        example.or().andKeywordLike("%"+keyword+"%").andDeletedEqualTo(false);
        return keywordMapper.selectByExample(example);
    }
}
