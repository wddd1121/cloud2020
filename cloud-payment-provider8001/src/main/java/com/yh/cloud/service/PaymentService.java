package com.yh.cloud.service;

import com.yh.cloud.dao.PaymentDao;
import com.yh.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yh
 * @date 2020-10-24-13:38
 */
@Service
public class PaymentService {

    @Autowired(required = false)
    PaymentDao paymentDao;

    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    public Payment get(Long id) {
        return paymentDao.get(id);
    }

}
