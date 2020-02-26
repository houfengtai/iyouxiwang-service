package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.constants.Constants;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.framework.core.commons.utils.ObjectUtil;
import com.suwen.iyouxiwang.dao.BrowseLogMapper;
import com.suwen.iyouxiwang.domain.BrowseLog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class BrowseLogServiceImpl implements BrowseLogService {
    @Autowired
    private BrowseLogMapper browseLogMapper;

    @Override
    public Response<String> saveBrowseLog(BrowseLog browseLog) {
        browseLogMapper.insertSelective(browseLog);
        return Response.returnData("保存成功");
    }

    @Override
    public Response<String> updateBrowseLog(BrowseLog browseLog) {
        if(ObjectUtil.isNull(browseLog.getId())) return  new Response(Constants.RESP_STATUS_BADREQUEST,"id不能为空");
        browseLogMapper.updateByPrimaryKeySelective(browseLog);
        return Response.returnData("修改成功");
    }

    @Override
    public Response<String> findBrowseLog() {
        return Response.returnData(new ArrayList());
    }
}
