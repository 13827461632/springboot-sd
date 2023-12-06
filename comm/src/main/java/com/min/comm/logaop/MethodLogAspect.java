package com.min.comm.logaop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Slf4j
public class MethodLogAspect {
    /**
     * 定义注解@MethodLog 切点
     */
    @Pointcut("@annotation(com.min.comm.logaop.MethodLog)")//指定切 MethodLog注解 使用自定义MethodLog注解 就会进入切面执行下面的步骤
    public void methodLog(){
        log.info("进来了......");//这写东西没有显示
    }
    @Before("methodLog()")
    public void doBefor(JoinPoint joinPoint){
        //记录方法的入参
        log.info("Requst method:{},Requst param:{}",joinPoint.getSignature().getName(), JSON.toJSONString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "o",pointcut = "methodLog()")
    public void afterReturning(Object o){
        //记录方法返回
        log.info("Requst Result:{}",JSON.toJSONString(o));
    }

}
