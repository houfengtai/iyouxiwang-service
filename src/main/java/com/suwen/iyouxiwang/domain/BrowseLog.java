package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BrowseLog {
    private Integer id;

    private Integer gameId;

    private Date createDate;

    private String browseIp;
}