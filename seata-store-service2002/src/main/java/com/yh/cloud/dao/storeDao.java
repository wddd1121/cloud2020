package com.yh.cloud.dao;

import com.yh.cloud.domain.store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yh
 * @date 2020-11-02-10:32
 */
@Mapper
public interface storeDao {

    void decreaseStore(@Param("productId") Long productId, @Param("count") int count);

    store get(@Param("id") Long id);
}
