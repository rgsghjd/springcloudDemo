package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //重新刷新
public class ConfigClientController
{
    @Value("${config}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() 
    {
        return "serverPort: "+serverPort+"\t\n\n configInfo: "+configInfo;
    }
}