package cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-31-15:24
 */
@Configuration
public class config {

    @Bean
    @LoadBalanced
    public RestTemplate get(){
        return new RestTemplate();
    }
}
