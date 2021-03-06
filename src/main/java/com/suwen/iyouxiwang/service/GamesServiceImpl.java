package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.constants.Constants;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.framework.core.commons.utils.ObjectUtil;
import com.suwen.iyouxiwang.dao.GamesMapper;
import com.suwen.iyouxiwang.domain.Games;
import com.suwen.iyouxiwang.domain.GamesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GamesServiceImpl implements GamesService {
    @Autowired
    private GamesMapper gamesMapper;

    @Override
    public Response<String> saveGames(Games games) {
        Integer id = gamesMapper.insertSelective(games);
        return Response.returnData("插入成功");
    }

    @Override
    public Response<String> updateGames(Games games) {
        if(ObjectUtil.isNull(games.getId())) return  new Response(Constants.RESP_STATUS_BADREQUEST,"id不能为空");
        Integer n = gamesMapper.updateByPrimaryKeySelective(games);
        return Response.returnData("更新成功");
    }

    @Override
    public Response<String> findGameViews(String keyword,Integer type,Integer columnType,Integer page, Integer pageSize) {
        if(pageSize > 50) return Response.returnData("");
        Integer count = gamesMapper.findGameViewsCount(keyword,type,columnType);
        Integer  pageNo = (page!=null && pageSize!=null)? (page - 1) * pageSize : null;
        List<GamesView> list = gamesMapper.findGameViews(keyword,type,columnType,pageNo, pageSize);
        Response res = new Response(200,"查询成功");
        res.setData(list);
        res.setPageNo(pageNo);
        res.setPageIndex(page);
        res.setPageSize(pageSize);
        res.setTotal(count);
        return res;
    }

    @Override
    public Response<String> findNewGameViews() {
        return Response.returnData(gamesMapper.findNewGameViews());
    }
}
