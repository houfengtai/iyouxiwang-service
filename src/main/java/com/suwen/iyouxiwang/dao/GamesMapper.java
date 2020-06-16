package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.Games;
import com.suwen.iyouxiwang.domain.GamesView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GamesMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Games record);

    Games selectByPrimaryKey(Integer id);

    int selectCountByGameType(@Param(value = "gameType") Integer gameType);

    GamesView selectByGameType(@Param(value = "gameType") Integer gameType,@Param(value = "start") Integer start);

    List<Games> selectByStatusAndType(@Param(value = "status") Integer status,@Param(value = "type") Integer type);

    int updateByPrimaryKeySelective(Games record);

    List<GamesView> findNewGameViews();

    List<GamesView> findGameViews(@Param(value = "keyword") String keyword,
                              @Param(value = "type") Integer type,
                              @Param(value = "columnType") Integer columnType,
                              @Param(value = "pageNo")Integer pageNo,
                              @Param(value = "pageSize")Integer pageSize);

    int findGameViewsCount(@Param(value = "keyword") String keyword,@Param(value = "type") Integer type,@Param(value = "columnType") Integer columnType);
}