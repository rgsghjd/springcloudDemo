package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 定义一个服务调用接口的实现类,可以进行服务降级方法的定义，将业务代码与降级方法进行分离
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService
{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) throws InterruptedException {
        return "服务调用失败,提示来自PaymentHystrixServiceImpl";
    }

}
