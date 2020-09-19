package com.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用硬编码配置文件的方式配置路由转发
 */
@Configuration
public class GatewayConfig {

    /**
     * 使用硬编码配置文件的方式配置路由转发
     * 需求1：使用路由跳转，跳转至百度国际新闻首页
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        /**
         * http://news.baidu.com/guoji
         * 当访问地址localhost:9002/guoji时，自动转发地址：http://news.baidu.com/guoji
         */
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route" ,
                r -> r.path("/guoji")
                        .uri("https://news.baidu.com/guoji"));
        return routes.build();
    }
}
