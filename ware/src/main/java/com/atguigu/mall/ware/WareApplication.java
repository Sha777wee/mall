package com.atguigu.mall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author shawee
 */
@SpringBootApplication
@MapperScan("com.atguigu.mall.ware.dao")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu.mall.ware.feign")
public class WareApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class, args);
    }

}
