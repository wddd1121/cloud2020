package com.yh.cloud.dao;

import com.yh.cloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author yh
 * @date 2020-10-31-20:46
 */
public interface orderDao {

    void createOrder(Order Order);


    void updateOrder(@Param("id") Long id,@Param("status") Integer status);

}
