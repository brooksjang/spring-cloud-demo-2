package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     //开启Eureka客户端服务
public class Provider_8003Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider_8003Application.class, args);
    }
}
