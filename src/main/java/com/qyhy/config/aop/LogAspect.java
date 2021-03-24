package com.qyhy.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author zhangdj
 * @date 2021/03/09
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.qyhy.dao.UserDao.*(..))")
    public void pointCut() {

    }

    /**
     * within 最小作用范围为类
     */
    @Pointcut("within(com.qyhy.dao.*)")
    public void pointCutWithin() {

    }

    /**
     * @within 标注了注解的会被代理
     */
    @Pointcut("@within(com.qyhy.config.Log)")
    public void pointCutWithinAnnotation() {

    }

    /**
     * 找到所有符合条件的方法
     * args指定方法的参数类型及个数
     */
    @Pointcut("args()")
    public void pointCutArgs() {

    }

    /**
     * @annotation 作用与标注了该注解的方法上
     */
    @Pointcut("@annotation(com.qyhy.config.Log)")
    public void pointCutAnnotation() {

    }

    /**
     * this 从spring中获取到的对象类型是UserDao 就会被代理 aop就会起作用
     * cglib代理 继承目标类    代理对象是UserDao的父类 所以可以被代理
     * jdk代理 继承Proxy类 实现dao接口 代理对象是dao的实现类以及Proxy的父类 所有不会被代理
     */
    @Pointcut("this(com.qyhy.dao.UserDao)")
    public void pointCutThis() {

    }

    /**
     * target 目标对象是UserDao aop就会起作用
     */
    @Pointcut("target(com.qyhy.dao.UserDao)")
    public void pointCutTarget() {

    }

    /**
     * @Before("pointCut() && !pointCutAnnotation()")  满足第一个条件 并且不满足第二个条件
     */
    @Before("pointCut() && !pointCutAnnotation()")
    public void doAccessCheck() {
        System.out.println("log2.......");
    }

    /**
     * @Around 环绕通知 可以改变目标方法的参数
     * @param pjp
     * @return
     */
    @Around("pointCutAnnotation()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        String tempArgs = "";
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            if (arg instanceof String) {
                tempArgs = arg + "mmmm";
            }
        }
        // stop stopwatch
        return pjp.proceed(new Object[]{tempArgs});
    }
}
