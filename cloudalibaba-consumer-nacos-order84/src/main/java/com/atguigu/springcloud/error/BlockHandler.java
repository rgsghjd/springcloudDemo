package com.atguigu.springcloud.error;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

public class BlockHandler {
    /*
        必须是static，参数列表相同，返回值相同，参数多一个BlockException
     */
    public static CommonResult<Payment> globalHandler(@PathVariable Long id, BlockException throwable){
        return new CommonResult<>(444,"全局配置异常处理");
    }
}
