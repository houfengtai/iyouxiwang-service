package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RecommendedGames {
    private Integer id;

    private String gameName;

    private String gameLogo;

    private String gameUrl;

    private String remark;

    private Integer seqNo;

    private Date createTime;

    private Integer createBy;

}