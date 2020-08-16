package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     //开启Eureka客户端服务
//添加对熔断的支持
@EnableCircuitBreaker
public class ProviderHystrix_8004Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix_8004Application.class, args);
    }
}
