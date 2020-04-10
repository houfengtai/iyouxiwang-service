package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.HotGames;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotGamesMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(HotGames record);

    HotGames selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotGames record);

    List<HotGames> selectList();
}