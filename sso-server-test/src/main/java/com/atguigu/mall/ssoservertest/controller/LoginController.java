package com.atguigu.mall.ssoservertest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Shawee
 * @Date 2023/11/25
 */
@RestController
public class LoginController {
    @PostMapping("/doLogin")
    public String doLogin() {
        // 登录成功,跳转到之前的页面
        return "";
    }

}
