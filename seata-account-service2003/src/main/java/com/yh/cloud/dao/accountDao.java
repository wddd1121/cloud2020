package com.yh.cloud.dao;

import com.yh.cloud.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author yh
 * @date 2020-11-02-10:48
 */
@Mapper
public interface accountDao {

    void decrease(@Param("userId") Long userId, @Param("count") BigDecimal count);

    Account get(@Param("id") Long id);
}
