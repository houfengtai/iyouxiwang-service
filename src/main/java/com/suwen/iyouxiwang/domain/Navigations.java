package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Navigations {
    private Integer id;

    private String navName;

    private Integer status;

    private Integer seqNo;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

}