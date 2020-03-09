package com.suwen.iyouxiwang.controller;


import com.suwen.framework.core.commons.annotation.IgnoreSecurity;
import com.suwen.framework.core.commons.resp.Response;
import com.suwen.iyouxiwang.service.NavigationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/nav")
@Api("栏目")
public class NavigationController {
    @Autowired
    private NavigationsService navigationsService;

    @GetMapping("/navs")
    @ApiOperation(value = "查询所有栏目")
    @IgnoreSecurity
    public Response<String> findNav(){
        return navigationsService.findNavigations();
    }
}
