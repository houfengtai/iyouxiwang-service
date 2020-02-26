package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.Games;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GamesMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Games record);

    Games selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Games record);
}