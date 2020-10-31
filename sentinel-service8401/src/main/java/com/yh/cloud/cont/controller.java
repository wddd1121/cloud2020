package com.yh.cloud.cont;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-30-20:43
 */
@RestController
@Slf4j
public class controller {

    @GetMapping("/testa")
    public String getA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testa";
    }

    @GetMapping("/testb")
    public String getB(){
        log.info(Thread.currentThread().getName());
        return "testb";
    }

    @GetMapping("/testC")
    public String getC(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("jmeter线程进来了"+Thread.currentThread().getName());
        return "testC";
    }


    @GetMapping("/testD")
    public String getD(){
        int a = 1/0;
        log.info("jmeter线程进来了"+Thread.currentThread().getName());
        return "testC";
    }


    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "handleHotkey")  // 对热点参数进行流量限制，只会处理在sentinel控制台配置的违规行为
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2){
        int a = 1/0;    // 自己抛出的异常是不会被sentinel处理的，此处不会被 handleHotkey 方法处理
        return "testHotkey";
    }

    public String handleHotkey(String p1, String p2, BlockException e){
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(e);
        return "handle hotkey"; // sentinel的默认提示：Blocked by Sentinel (flow limiting)
    }


}
