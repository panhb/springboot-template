package com.panhb.aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author hongbo.pan
 * @date 2018/8/17
 */
@Component
@Aspect
public class DemoAspect {

    @Pointcut(value = "@annotation(com.panhb.annotation.DemoAnnotation)")
    public void demo() {

    }

    @Before("demo()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录下请求内容
        System.out.println("class_method : " + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        System.out.println("args : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "demo()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     *
     * @param jp
     */
    @AfterThrowing("demo()")
    public void doThrows(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     *
     * @param jp
     */
    @After("demo()")
    public void doAfter(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     *
     * @param pjp
     * @return
     */
    @SneakyThrows
    @Around("demo()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        Object o =  pjp.proceed();
        System.out.println("方法环绕proceed，结果是 :" + o);
        return o;
    }
}
