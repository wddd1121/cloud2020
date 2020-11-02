package com.yh.cloud.cont;

import com.yh.cloud.dao.storeDao;
import com.yh.cloud.domain.CommonResult;
import com.yh.cloud.domain.store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author yh
 * @date 2020-11-02-10:38
 */
@RestController
public class controller {

    @Autowired
    storeDao storeDao;

    /**
     *
     * @param productId     货物id
     * @param count         减少的库存量
     * @return
     */
    @GetMapping("/decreaseStore")
    public CommonResult decreaseStore(@RequestParam("productId") Long productId,
                               @RequestParam("count") Integer count){

        // 模拟超时
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        store store = storeDao.get(productId);
        System.out.println(store);
        if (store.getResidue() < count){
            return new CommonResult(500, "库存为空");
        }

        storeDao.decreaseStore(productId, count);
        return new CommonResult();
    }

}
