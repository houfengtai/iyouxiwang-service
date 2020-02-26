package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Games {
    private Integer id;

    private String gameName;

    private String gameLogo;

    private String gameUrl;

    private String intro;

    private Integer status;

    private Integer gameType;

    private Integer type;

    private Date startDate;

    private Date endDate;

    private String remark;

    private Integer advertiserId;

    private Integer seqNo;

    private Date createTime;

    private Integer createBy;
}