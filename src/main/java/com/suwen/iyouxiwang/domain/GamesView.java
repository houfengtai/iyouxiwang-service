package com.suwen.iyouxiwang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class GamesView {
    private Integer id;

    private String gameName;

    private String gameLogo;

    private String gameUrl;

    private String intro;

}