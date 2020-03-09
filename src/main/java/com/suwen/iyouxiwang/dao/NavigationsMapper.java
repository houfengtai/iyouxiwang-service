package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.Navigations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NavigationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Navigations record);

    Navigations selectByPrimaryKey(Integer id);

    List<Navigations> findList();

    int updateByPrimaryKeySelective(Navigations record);
}