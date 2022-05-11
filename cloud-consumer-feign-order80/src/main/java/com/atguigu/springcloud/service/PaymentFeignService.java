package com.atguigu.springcloud.service;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//微服务暴露接口服务,需要指定调用的微服务名称,以及微服务路径
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    //Feign的路径变量必须加上value属性否则会抛出异常
    CommonResult get(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout/{id}")
    CommonResult timeout(@PathVariable("id") Long id) throws InterruptedException;
}
