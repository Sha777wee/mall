package com.atguigu.mall.product.exception;

import com.atguigu.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Shawee
 * @Date 2023/11/11
 */

@Slf4j
@RestControllerAdvice(basePackages = "com.atguigu.mall.product.controller")
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleValidationException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题：{}，异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(item -> {
                    errorMap.put(item.getField(), item.getDefaultMessage());
                }
        );
        return R.error(400, "数据校验出现问题").put("date", errorMap);
    }

    @ExceptionHandler(Throwable.class)
    public R handleException(Exception e) {
        e.printStackTrace();
        return R.error();
    }
}
