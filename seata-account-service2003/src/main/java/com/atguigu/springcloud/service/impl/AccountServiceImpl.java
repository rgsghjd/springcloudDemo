package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        //try { TimeUnit.SECONDS.sleep(30); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
