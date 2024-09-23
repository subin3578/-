package com.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component // name : myAdvice
public class MyAdvice {

    // 포인트 컷
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointCut(){} // 핵심 관심을 가리키는 내용이 없는 메서드

    @Pointcut("execution(void com.ch03.MyService.select(..))")
    public void selectPointCut(){}

    @Before("insertPointCut() || selectPointCut()")
    public void beforeAdvice() {
        System.out.println("부가기능 - beforeAdvice ...");
    }
    @After("insertPointCut()")
    public void afterAdvice() {
        System.out.println("부가기능 - afterAdvice ...");
    }
    @AfterReturning("insertPointCut()")
    public void afterReturnAdvice() {
        System.out.println("부가기능 - afterReturnAdvice ...");
    }

    // 부가기능 메서드 내에서 핵심관심을 실행하고 부가기능의 위치를 정함
    @Around("insertPointCut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("부가기능 - aroundAdvice ...1");
        pjp.proceed(); // 핵심관심
        System.out.println("부가기능 - aroundAdvice ...2");
    }

    @AfterThrowing("selectPointCut()")
    public void afterThrowAdvice() {
        System.out.println("부가기능 - afterThrowAdvice ...");
    }
}
