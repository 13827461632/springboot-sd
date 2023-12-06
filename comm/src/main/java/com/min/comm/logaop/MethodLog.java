package com.min.comm.logaop;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})//定义到方法上
@Documented
public @interface MethodLog {
}
