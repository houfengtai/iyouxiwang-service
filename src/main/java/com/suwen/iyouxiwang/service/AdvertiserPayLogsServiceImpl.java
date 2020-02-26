package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.constants.Constants;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.framework.core.commons.utils.ObjectUtil;
import com.suwen.iyouxiwang.dao.AdvertiserPayLogsMapper;
import com.suwen.iyouxiwang.domain.AdvertiserPayLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdvertiserPayLogsServiceImpl implements AdvertiserPayLogsService{
    @Autowired
    private AdvertiserPayLogsMapper advertiserPayLogsMapper;

    @Override
    public Response<String> saveAdvertiserPayLogs(AdvertiserPayLogs advertiserPayLogs) {
        advertiserPayLogsMapper.insertSelective(advertiserPayLogs);
        return Response.returnData("保存成功");
    }

    @Override
    public Response<String> updateAdvertiserPayLogs(AdvertiserPayLogs advertiserPayLogs) {
        if(ObjectUtil.isNull(advertiserPayLogs.getId())) return  new Response(Constants.RESP_STATUS_BADREQUEST,"id不能为空");
        advertiserPayLogsMapper.updateByPrimaryKeySelective(advertiserPayLogs);
        return Response.returnData("修改成功");
    }

    @Override
    public Response<String> findAdvertiserPayLogs() {
        return Response.returnData(new ArrayList());
    }
}
