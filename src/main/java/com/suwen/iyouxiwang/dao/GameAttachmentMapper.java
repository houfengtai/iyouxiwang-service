package com.suwen.iyouxiwang.dao;

import com.suwen.iyouxiwang.domain.GameAttachment;
import com.suwen.iyouxiwang.domain.GameAttachmentView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GameAttachmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(GameAttachment record);

    GameAttachment selectByPrimaryKey(Integer id);

    List<GameAttachmentView> selectByType(@Param(value = "type") Integer type,@Param(value = "pageNo")Integer pageNo,
                                          @Param(value = "pageSize")Integer pageSize);

    int updateByPrimaryKeySelective(GameAttachment record);
}