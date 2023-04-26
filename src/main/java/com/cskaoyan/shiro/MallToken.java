package com.cskaoyan.shiro;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by 张凡 on 2020/5/5 14:07
 */
@Data
public class MallToken extends UsernamePasswordToken {
    String type;
    public MallToken(String username,String password,String type){
        super(username,password);
        this.type=type;

    }
}
