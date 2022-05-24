package com.wwh.springcloud.annotation;

import java.lang.annotation.*;

/**
 * @author wuweihao5
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateRequest {

    //模块 例如User
    String prefix() default "";

    //具体功能 例如用户注册
    String suffix() default "";

    //完整的code  错误码
    String full() default "";

    //若入参继承Verifiable接口，设置为true，则进行校验
    boolean check() default true;
}
