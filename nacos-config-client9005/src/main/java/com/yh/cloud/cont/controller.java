package com.yh.cloud.cont;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-30-8:51
 */
@RefreshScope   // 支持nacos配置动态刷新
@RestController
public class controller {


    @Value("${config.info}")
    private String info;

    @GetMapping("/get")
    public String getConfig(){
        return info;
    }

}
