package com.atguigu.mall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author shawee
 */
@SpringBootApplication
@MapperScan("com.atguigu.mall.order.dao")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu.mall.order.feign")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
