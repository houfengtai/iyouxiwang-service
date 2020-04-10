package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.RecommendedGames;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendedGamesMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(RecommendedGames record);

    RecommendedGames selectByPrimaryKey(Integer id);

    List<RecommendedGames> selectList();

    int updateByPrimaryKeySelective(RecommendedGames record);
}