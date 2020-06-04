package com.suwen.iyouxiwang.controller;

import com.suwen.framework.core.commons.annotation.IgnoreSecurity;
import com.suwen.framework.core.commons.exception.CustomException;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.dao.GameAttachmentMapper;
import com.suwen.iyouxiwang.dao.GamesMapper;
import com.suwen.iyouxiwang.dao.HotGamesMapper;
import com.suwen.iyouxiwang.dao.RecommendedGamesMapper;
import com.suwen.iyouxiwang.domain.GameAttachmentView;
import com.suwen.iyouxiwang.domain.GamesView;
import com.suwen.iyouxiwang.service.GamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    @Autowired
    private GamesMapper gamesMapper;
    @Autowired
    private GameAttachmentMapper gameAttachmentMapper;

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
    @GetMapping("/type/games")
    @ApiOperation(value = "查询首页游戏分类2个游戏")
    @IgnoreSecurity
    public Response<String> getIndex2Games() throws CustomException {
        Random rand = new Random();
        int qp_num = gamesMapper.selectCountByGameType(0);
        int cq_num = gamesMapper.selectCountByGameType(1);

        Map<String, GamesView> map = new HashMap<>();
        if(qp_num!=0) map.put("qp", gamesMapper.selectByGameType(0,rand.nextInt(qp_num)));
        if(cq_num!=0) map.put("cq",gamesMapper.selectByGameType(1,rand.nextInt(cq_num)));
        return Response.returnData(map);
    }
    @GetMapping("/games/view")
    @ApiOperation(value = "查询首页游戏最新视频与最新图片")
    @IgnoreSecurity
    public Response<String> getImgAndVideo() throws CustomException {

        Map<String, List<GameAttachmentView>> map = new HashMap<>();
        map.put("images", gameAttachmentMapper.selectByType(0,0,3));
        map.put("videos",gameAttachmentMapper.selectByType(1,0,3));
        return Response.returnData(map);
    }
}
