package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    String port;
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if(i > 0 ){
            return new CommonResult(200,"添加成功,端口:" + port,i);
        }else {
            return new CommonResult(400,"添加失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("获取数据,{}" , paymentById);
        if(paymentById == null) {
            return new CommonResult(400,"请求资源不存在",null);
        }else
        return new CommonResult(200,"获取资源成功,端口" + port,paymentById);
    }
}
