package com.suwen.iyouxiwang.controller;

import com.suwen.framework.core.commons.annotation.IgnoreSecurity;
import com.suwen.framework.core.commons.exception.CustomException;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.framework.core.commons.rest.BaseController;
import com.suwen.framework.core.commons.utils.ObjectUtil;
import com.suwen.iyouxiwang.domain.BrowseLog;
import com.suwen.iyouxiwang.service.BrowseLogService;
import com.suwen.iyouxiwang.service.GamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/game")
@Api("游戏")
public class GamesController extends BaseController{
    @Autowired
    private GamesService gamesService;
    @Autowired
    private BrowseLogService browseLogService;

    @GetMapping("/games")
    @ApiOperation(value = "查询游戏列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "c", value = "游戏大类", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "k", value = "关键字", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "t", value = "游戏类型", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", paramType = "query", dataType = "int")
    })
    @IgnoreSecurity
    public Response<String> findGames (@RequestParam(value = "c", required = false) Integer columnType,
                                 @RequestParam(value = "k", required = false) String keyword,
                                 @RequestParam(value = "t", required = false) Integer type,
                                       @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                                       @RequestParam(value = "pageSize", required = false,defaultValue = "10") Integer pageSize
                                       ) throws CustomException {
        String p = ObjectUtil.isNull(keyword)?null:"%"+keyword+"%";
        return gamesService.findGameViews(p,type,columnType,pageIndex,pageSize);
    }

    @GetMapping("/browselog/{id}")
    @ApiImplicitParam(name = "id", value = "游戏id", paramType = "path", dataType = "int")
    @IgnoreSecurity
    public Response<String> addBrowseLog(@PathVariable Integer id,HttpServletRequest request){
        BrowseLog browseLog = new BrowseLog();
        browseLog.setGameId(id);
        browseLog.setCreateDate(new Date());
        //browseLog.setBrowseIp(getIpFromRequest(request));
        browseLog.setBrowseIp(request.getHeader("X-real-ip"));
        return browseLogService.saveBrowseLog(browseLog);
    }
}
