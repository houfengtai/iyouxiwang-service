package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.domain.Navigations;

public interface NavigationsService {
    Response<String> saveNavigations(Navigations navigations);
    Response<String> updateNavigations(Navigations navigations);
    Response<String> findNavigations();
}
