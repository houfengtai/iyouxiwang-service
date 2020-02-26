package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.BrowseLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrowseLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(BrowseLog record);

    BrowseLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrowseLog record);
}