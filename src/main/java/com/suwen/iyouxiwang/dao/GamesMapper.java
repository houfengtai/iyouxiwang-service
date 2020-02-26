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

    int updateByPrimaryKeySelective(Games record);

    List<GamesView> findGames(@Param(value = "keyword") String keyword,
                              @Param(value = "type") Integer type,
                              @Param(value = "pageNo")Integer pageNo,
                              @Param(value = "pageSize")Integer pageSize);

    int findGamesCount(@Param(value = "keyword") String keyword,@Param(value = "type") Integer type);
}