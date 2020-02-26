package com.suwen.iyouxiwang.service;

import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.domain.BrowseLog;

public interface BrowseLogService {
    Response<String> saveBrowseLog(BrowseLog browseLog);
    Response<String> updateBrowseLog(BrowseLog browseLog);
    Response<String> findBrowseLog();
}
