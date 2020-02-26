package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.domain.AdvertiserPayLogs;

public interface AdvertiserPayLogsService {
    Response<String> saveAdvertiserPayLogs(AdvertiserPayLogs advertiserPayLogs);
    Response<String> updateAdvertiserPayLogs(AdvertiserPayLogs advertiserPayLogs);
    Response<String> findAdvertiserPayLogs();
}
