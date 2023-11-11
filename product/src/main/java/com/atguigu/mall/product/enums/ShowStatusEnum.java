package com.atguigu.mall.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author Shawee
 * @Date 2023/11/11
 */

@Getter
@AllArgsConstructor
public enum ShowStatusEnum {

    SHOW(1, "显示"),
    HIDE(0, "隐藏");

    private Integer code;

    private String name;

    public static Boolean isValid(Integer code) {
        return Arrays.stream(values()).map(ShowStatusEnum::getCode).collect(Collectors.toList()).contains(code);
    }
}
