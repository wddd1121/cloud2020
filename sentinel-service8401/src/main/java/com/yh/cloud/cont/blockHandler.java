package com.yh.cloud.cont;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yh.cloud.pojo.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author yh
 * @date 2020-10-31-14:56
 */
public class blockHandler{

    public static CommonResult handleBlock1(BlockException e){
        return new CommonResult(444,"handle1号");

    }

    public static  CommonResult handleBlock2(BlockException e){
        return new CommonResult(444,"handle2号");

    }
}
