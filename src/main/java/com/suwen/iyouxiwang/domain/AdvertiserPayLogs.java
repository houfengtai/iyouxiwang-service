package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AdvertiserPayLogs {
    private Integer id;

    private Integer status;

    private Integer type;

    private BigDecimal amount;

    private Integer advertiserId;

    private String remark;

    private Date createTime;

    private Integer createBy;
}