package com.clibchina.web.anno;

import com.clibchina.web.enums.MethodEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by changlifeng on 16/12/29.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

    MethodEnum method() default MethodEnum.GET;
    String value();

}
