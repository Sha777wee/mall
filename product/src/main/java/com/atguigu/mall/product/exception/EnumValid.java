package com.atguigu.mall.product.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * @Author Shawee
 * @Date 2023/11/11
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {EnumValidConstraintValidator.class}
)
public @interface EnumValid {
    Class target();

    String targetMethod() default "isValid";

    String message() default "数据有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
