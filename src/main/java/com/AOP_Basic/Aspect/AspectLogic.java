package com.AOP_Basic.Aspect;

import com.AOP_Basic.Exception.MyException;
import com.AOP_Basic.Model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectLogic {
    Logger log = LoggerFactory.getLogger(AspectLogic.class);

    @Pointcut(value = "execution(* com.AOP_Basic.*.*.*(..))")
    public void myPointCut() {
    }

    @Pointcut(value = "execution(* com.AOP_Basic.AOPService.*.throwException(..))")
    public void myPointCutThrow() {
    }


//    @Before("myPointCut()")
//    public void waveBefore() {
//        log.info("Before--i'm waving from aspect");
//    }

    //    @After("myPointCut()")
//    public void waveAfter() {
//        log.info("After--i'm waving from aspect");
//    }
//    @AfterReturning(value = "myPointCut()", returning = "returnValue")
//    public void afterReturning(Product returnValue) {
//        System.out.println(returnValue);
//    }
//    @AfterThrowing(value = "myPointCutThrow()",throwing = "ex")
//    public void waveThrowing(MyException ex) {
//        log.info("my custom exception"+ex);
//    }
//    @Around("myPointCut()")
//    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
//        String methodName = pjp.getSignature().getName();
//        System.out.println(methodName);
//        Product proceed = (Product) pjp.proceed();
//        proceed.setPrice(000);
//        return proceed;
//    }
    @Around("myPointCut()")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        System.out.println("Before-----");
        log.info("Class name -> " + className + " Method Name-> " + methodName + "  Args ->" + mapper.writeValueAsString(args));
        Object proceed = pjp.proceed();
        System.out.println("After----");
      log.info("result-"+mapper.writeValueAsString(proceed));
        System.out.println("testing dev changes");
        return proceed;
    }
}