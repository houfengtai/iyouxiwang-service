package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.constants.Constants;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.framework.core.commons.utils.ObjectUtil;
import com.suwen.iyouxiwang.dao.AdvertisersMapper;
import com.suwen.iyouxiwang.domain.Advertisers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AdvertisersServiceImpl implements AdvertisersService {
    @Autowired
    private AdvertisersMapper advertisersMapper;
    @Override
    public Response<String> saveAdvertisers(Advertisers advertisers) {
        advertisersMapper.insertSelective(advertisers);
        return Response.returnData("保存成功");
    }

    @Override
    public Response<String> updateAdvertisers(Advertisers advertisers) {
        if(ObjectUtil.isNull(advertisers.getId())) return  new Response(Constants.RESP_STATUS_BADREQUEST,"id不能为空");
        advertisersMapper.updateByPrimaryKeySelective(advertisers);
        return Response.returnData("修改成功");
    }

    @Override
    public Response<String> findAdvertisers() {
        return Response.returnData(new ArrayList());
    }
}
