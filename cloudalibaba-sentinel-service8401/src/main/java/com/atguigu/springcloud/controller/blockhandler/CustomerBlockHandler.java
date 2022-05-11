package com.atguigu.springcloud.controller.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
public class CustomerBlockHandler {
    public static CommonResult globalHandler(BlockException exception){
        return new CommonResult(444,"按资源名称限流测试失败",new Payment(2020L,"serial001"));

    }
    public static String error01(){
        return "┭┮﹏┭┮";
    }
}
