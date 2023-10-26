package com.atguigu.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author shawee
 */
@SpringBootApplication
@MapperScan("com.atguigu.mall.product.dao")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu.mall.product.feign")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
