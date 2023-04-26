package com.cskaoyan.service;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张凡 on 2020/5/4 11:50
 */
@Service
public class UserInfoService {
    @Autowired
    UserService userService;
    public UserInfo getInfo(Integer userId){
        User user = userService.findById(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
