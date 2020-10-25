package com.yh.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yh
 * @date 2020-10-25-11:35
 */
@Configuration
public class selfRule {

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }

}
