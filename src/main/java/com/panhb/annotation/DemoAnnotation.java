package com.panhb.annotation;

import java.lang.annotation.*;

/**
 * @author hongbo.pan
 * @date 2018/8/17
 */
//作用在方法上
@Target({ElementType.METHOD})
// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
//说明该注解将被包含在javadoc中
@Documented
public @interface DemoAnnotation {

}
