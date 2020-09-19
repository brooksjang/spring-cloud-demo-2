package com.ruleconfig;

import com.netflix.loadbalancer.IRule;
import com.ruleconfig.MyRandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule myRandomRule() {
        return new MyRandomRule();
    }
}
