package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.AdvertiserPayLogs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertiserPayLogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(AdvertiserPayLogs record);

    AdvertiserPayLogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdvertiserPayLogs record);
}