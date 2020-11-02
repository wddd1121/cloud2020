package com.yh.cloud.service;

import com.yh.cloud.dao.orderDao;
import com.yh.cloud.domain.CommonResult;
import com.yh.cloud.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yh
 * @date 2020-10-31-20:50
 */
@Service
@Slf4j
public class orderService {



    @Autowired
    orderDao orderDao;

    @Autowired
    accountService accountService;

    @Autowired
    storeService storeService;

    // 创建订单，减库存，减账户余额，改订单状态
    @GlobalTransactional(name = "fsp-order-transaction",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("进入orderservice， 开启全局事务");
        orderDao.createOrder(order);

        CommonResult commonResult = storeService.decreaseStore(order.getProductId(), order.getCount());
        if (commonResult.getCode() == 500){
            log.info(commonResult.getMessage());
            throw new RuntimeException(commonResult.getMessage());
        }


        CommonResult commonResult1 = accountService.decreaseMoney(order.getUserId(), order.getMoney());
        if (commonResult1.getCode() == 500){
            log.info(commonResult1.getMessage());
            throw new RuntimeException(commonResult1.getMessage());
        }

        orderDao.updateOrder(order.getId(), 0);

    }

}
