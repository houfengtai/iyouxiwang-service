package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class GameAttachment {
    private Integer id;

    private String resourceUrl;

    private Integer type;

    private String remark;

    private Integer gameId;

    private Integer status;

    private Date createTime;

    private Integer createBy;
}