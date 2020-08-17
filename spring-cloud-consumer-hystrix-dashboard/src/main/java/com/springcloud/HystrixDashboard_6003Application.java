package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启监控页面
public class HystrixDashboard_6003Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard_6003Application.class, args);
    }
}
