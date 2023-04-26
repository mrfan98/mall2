package com.cskaoyan.bean;

import lombok.Data;

import java.util.List;

/**
 * Created by 张凡 on 2020/5/3 13:49
 */
@Data
public class RegionVo {
    private Integer id;
    private String name;
    private Byte type;
    private Integer code;
    private List<RegionVo> children;
}
