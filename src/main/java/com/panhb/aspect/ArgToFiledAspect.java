package com.panhb.aspect;

import com.panhb.annotation.ArgToFiled;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hongbo.pan
 * @date 2018/10/18
 */
@Aspect
@Component
public class ArgToFiledAspect {

    /**
     * 切点
     *
     * @param argToFiled
     */
    @Pointcut(value = "@annotation(argToFiled)")
    public void pointcut(ArgToFiled argToFiled) {
    }

    /**
     * 环绕
     *
     * @param pjp
     * @param argToFiled
     * @return
     * @throws Throwable
     */
    @Around("pointcut(argToFiled)")
    public Object around(ProceedingJoinPoint pjp, ArgToFiled argToFiled) throws Throwable {
        Object[] args = pjp.getArgs();
        Object voObject =  pjp.proceed(args);
        String[] argNames = argToFiled.argNames();
        String[] filedNames = argToFiled.filedNames();
        if (ArrayUtils.isNotEmpty(argNames) && ArrayUtils.isNotEmpty(filedNames)) {
            voObject = setFiledsValue(pjp, voObject, argNames, filedNames);
        }
        return voObject;
    }

    /**
     * 字段赋值
     *
     * @param pjp
     * @param voObject
     * @param argNames
     * @param filedNames
     * @return
     */
    private Object setFiledsValue(ProceedingJoinPoint pjp, Object voObject, String[] argNames, String[] filedNames) {
        Object[] args = pjp.getArgs();
        //获取方法参数
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //获取方法参数名
        String[] paramNames = signature.getParameterNames();
        //获取方法参数类型
        Class[] classes = signature.getParameterTypes();
        for (int i = 0; i < argNames.length; i++) {
            //获取参数名的位置
            int paramIndex = ArrayUtils.indexOf(paramNames, argNames[i]);
            if (paramIndex > -1) {
                Object paramValue = args[paramIndex];
                if (paramValue != null) {
                    voObject = invokeSetMethodIgnoreException(voObject, classes[i], filedNames[i], paramValue);
                }
            }
        }
        return voObject;
    }

    private Object invokeSetMethodIgnoreException(Object voObject, Class paramType, String filedName, Object filedValue) {
        try {
            voObject = invokeSetMethod(voObject, paramType, filedName, filedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voObject;
    }

    /**
     * 反射调用set方法
     *
     * @param object
     * @param paramType 参数类型
     * @param filedName 参数名
     * @param filedValue 参数值
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object invokeSetMethod(Object object, Class paramType, String filedName, Object filedValue) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        String setMethodName = "set" +
                filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
        Method method = clazz.getMethod(setMethodName, paramType);
        if (method != null) {
            method.invoke(object, filedValue);
        }
        return object;
    }

}
