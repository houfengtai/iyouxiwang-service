package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.domain.Games;

public interface GamesService {
    Response<String> saveGames(Games games);
    Response<String> updateGames(Games games);
    Response<String> findGameViews(String keyword,Integer type,Integer columnType,Integer page, Integer pageSize);
    Response<String> findNewGameViews();
}
