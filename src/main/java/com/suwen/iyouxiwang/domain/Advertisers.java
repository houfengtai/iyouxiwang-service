package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Advertisers {
    private Integer id;

    private String name;

    private String phone;

    private String qq;

    private String email;

    private Date createTime;
}