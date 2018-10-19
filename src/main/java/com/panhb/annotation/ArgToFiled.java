package com.panhb.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hongbo.pan
 * @date 2018/10/18
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArgToFiled {

    /**
     * 方法中的参数名
     */
    String[] argNames() default {"status"};

    /**
     * 返回VO中需要赋值的字段名
     */
    String[] filedNames() default {"status"};

}
