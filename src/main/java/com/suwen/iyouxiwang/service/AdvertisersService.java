package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.domain.Advertisers;

public interface AdvertisersService {
    Response<String> saveAdvertisers(Advertisers advertisers);
    Response<String> updateAdvertisers(Advertisers advertisers);
    Response<String> findAdvertisers();
}
