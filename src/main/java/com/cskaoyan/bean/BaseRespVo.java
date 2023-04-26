package com.cskaoyan.bean;

import lombok.Data;

/**
 * Created by 张凡 on 2020/4/24 9:47
 */
@Data
public class BaseRespVo<T> {
    T data;
    int errno;
    String errmsg;
}
