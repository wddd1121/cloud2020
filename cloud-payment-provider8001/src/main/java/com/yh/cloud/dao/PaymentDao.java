package com.yh.cloud.dao;

import com.yh.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author yh
 * @date 2020-10-24-13:25
 */

public interface PaymentDao {

    int save( Payment payment);

    Payment get(@Param("id") Long id);
}
