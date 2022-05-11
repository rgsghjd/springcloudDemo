package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
@Slf4j
public class AccountServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    AccountService accountService;
    @Resource
    StorageService storageService;
    @GlobalTransactional(name = "fsp_tx_group",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("------->下单开始");
        orderDao.create(order);
        log.info("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->order-service中扣减库存结束");
        log.info("------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->order-service中扣减余额结束");
        log.info("------->order-service中修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------->order-service中修改订单状态结束");
        log.info("------->下单结束");

    }
}
