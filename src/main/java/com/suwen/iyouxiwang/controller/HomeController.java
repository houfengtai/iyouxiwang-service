package com.suwen.iyouxiwang.controller;

import com.suwen.framework.core.commons.annotation.IgnoreSecurity;
import com.suwen.framework.core.commons.exception.CustomException;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.dao.HotGamesMapper;
import com.suwen.iyouxiwang.dao.RecommendedGamesMapper;
import com.suwen.iyouxiwang.service.GamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/home")
@Api("首页")
public class HomeController {
    @Autowired
    private HotGamesMapper hotGamesMapper;
    @Autowired
    private RecommendedGamesMapper recommendedGamesMapper;
    @Autowired
    private GamesService gamesService;

    @GetMapping("/hot/games")
    @ApiOperation(value = "查询首页火热游戏列表")
    @IgnoreSecurity
    public Response<String> getIndexHotGames() throws CustomException {
        return Response.returnData(hotGamesMapper.selectList());
    }

    @GetMapping("/new/games")
    @ApiOperation(value = "查询首页最新游戏列表")
    @IgnoreSecurity
    public Response<String> getIndexNewGames() throws CustomException {
        return gamesService.findNewGameViews();
    }

    @GetMapping("/recommend/games")
    @ApiOperation(value = "查询首页推荐游戏列表")
    @IgnoreSecurity
    public Response<String> getIndexRecommendGames() throws CustomException {
        return Response.returnData(recommendedGamesMapper.selectList());
    }
}
