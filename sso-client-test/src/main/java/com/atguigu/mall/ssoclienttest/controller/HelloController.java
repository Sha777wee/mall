package com.atguigu.mall.ssoclienttest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author Shawee
 * @Date 2023/11/25
 */

@RestController
public class HelloController {

    /**
     * 无需登录即可访问
     *
     * @return
     */
    @RequestMapping("/Hello")
    public String hello() {
        return "hello";
    }

    /**
     * 需要登录才可以访问
     *
     * @return
     */
    @RequestMapping("/employee")
    public String employee(HttpSession session) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            // 跳转登录服务器进行登录

            return "";
        }
        return "employee";
    }
}
