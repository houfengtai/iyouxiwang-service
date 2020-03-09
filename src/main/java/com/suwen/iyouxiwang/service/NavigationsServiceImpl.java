package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.constants.Constants;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.framework.core.commons.utils.ObjectUtil;
import com.suwen.iyouxiwang.dao.NavigationsMapper;
import com.suwen.iyouxiwang.domain.Navigations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationsServiceImpl implements NavigationsService {
    @Autowired
    private NavigationsMapper navigationsMapper;

    @Override
    public Response<String> saveNavigations(Navigations navigations) {
        navigationsMapper.insertSelective(navigations);
        return Response.returnData("保存成功");
    }

    @Override
    public Response<String> updateNavigations(Navigations navigations) {
        if(ObjectUtil.isNull(navigations.getId())) return new Response(Constants.RESP_STATUS_BADREQUEST,"id不能为空");
        navigationsMapper.updateByPrimaryKeySelective(navigations);
        return Response.returnData("修改成功");
    }

    @Override
    public Response<String> findNavigations() {
        List<Navigations> list = navigationsMapper.findList();
        return Response.returnData(list);
    }
}
