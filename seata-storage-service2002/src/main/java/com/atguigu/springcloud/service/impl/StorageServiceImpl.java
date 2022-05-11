package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }
}
