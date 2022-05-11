package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
@RestController
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.get(id);
    }
    @GetMapping(value = "/consumer/payment/timeout/get/{id}")
    public CommonResult<Payment> getPaymentByIdTimeOut(@PathVariable("id") Long id) throws InterruptedException {
        return paymentFeignService.timeout(id);
    }
}

