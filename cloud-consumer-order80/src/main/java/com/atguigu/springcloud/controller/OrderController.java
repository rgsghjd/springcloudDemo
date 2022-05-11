package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
//    private String BASE_URL = "http://localhost:8001";
    public static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_SRV + "/payment/create",payment,CommonResult.class);

    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_SRV + "/payment/get/" + id,CommonResult.class);
    }
    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://CLOUD-PAYMENT-SERVICE"+"/payment/zipkin/", String.class);
        return result;
    }

}
