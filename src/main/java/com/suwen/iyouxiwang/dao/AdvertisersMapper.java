package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.Advertisers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertisersMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Advertisers record);

    Advertisers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advertisers record);
}