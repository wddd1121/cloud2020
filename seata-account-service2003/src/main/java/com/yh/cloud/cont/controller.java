package com.yh.cloud.cont;

import com.yh.cloud.dao.accountDao;
import com.yh.cloud.domain.Account;
import com.yh.cloud.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yh
 * @date 2020-11-02-10:38
 */
@RestController
@Slf4j
public class controller {

    @Resource
    accountDao accountDao;

    @GetMapping("/decreaseMoney")
    public CommonResult decreaseMoney(@RequestParam("userId") Long userId, @RequestParam("count") BigDecimal count){

        Account account = accountDao.get(userId);
        System.out.println(account);
        if (account.getResidue().compareTo(count) == -1){
            return new CommonResult(500, "用户余额不足");
        }
        accountDao.decrease(userId, count);

        return new CommonResult();
    }

}
