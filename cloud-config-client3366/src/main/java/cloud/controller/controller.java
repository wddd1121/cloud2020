package cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-28-17:12
 */
@RefreshScope
@RestController
public class controller {

    @Value("${config.info}")
    String info;

    @GetMapping("/getConfig")
    String getRemoteConfig(){
        return info;
    }
}
