package com.cms.cloud.api.aop;

import java.lang.annotation.*;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    LogType value() default LogType.READ;

}