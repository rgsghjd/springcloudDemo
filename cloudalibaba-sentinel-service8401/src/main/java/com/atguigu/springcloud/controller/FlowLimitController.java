package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
public class FlowLimitController
{

    @GetMapping("/testA")
    public String testA()
    {
        System.out.println(Thread.currentThread().getName());
        log.info("====testA===");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()

    {
        log.info("====testB===");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        int i = 10 / 0;
        log.info("testD 测试RT");
        return "------testD";
    }

    /**
     * 热点限流只能通过SentinelResource 的value来配置资源限流 不能通过路径来进行热点限流
     * @param p1
     * @param p2
     * @return
     */
    @SentinelResource(value = "testKey",blockHandler = "GlobalBlockException")
    @GetMapping("/testHotKey")
    public String testHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
    ){
//        int a = 10 /0;

        return "------testHotKey01";
    }

    /**
     * 一个参数都不能少
     * @param p1
     * @param p2
     * @param exc
     * @return
     */
    public String GlobalBlockException(String p1, String p2, BlockException exc){
        return "GlobalBlockException,┭┮﹏┭┮";
    }

}