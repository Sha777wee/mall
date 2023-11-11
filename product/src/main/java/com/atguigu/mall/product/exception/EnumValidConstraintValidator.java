package com.atguigu.mall.product.exception;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * @Author Shawee
 * @Date 2023/11/11
 */
@Slf4j
public class EnumValidConstraintValidator implements ConstraintValidator<EnumValid, Integer> {

    private Class<?> validateClass;

    private String validateMethod;

    @Override
    public void initialize(EnumValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        validateClass = constraintAnnotation.target();
        validateMethod = constraintAnnotation.targetMethod();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        try {
            Method method = validateClass.getDeclaredMethod(validateMethod, Integer.class);
            return (Boolean) method.invoke(null, value);
        } catch (Exception e) {
            log.info("检验失败");
            throw new RuntimeException(e);
        }
    }
}
