package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ParameterAop {
	
	// controller 패키지 하위에 있는 모든 메서드를 찾아 보겠다( 관심을 받겠다.)
	@Pointcut(value = "execution(* com.example.demo.controller..*.*(..))")
	public void myPointCut() {}

	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		//aop를 활용해서 어떤 클래스에 어떤 메서드가 동작 했는지 먼저 알아 볼 수 있다.
		// 1. 메서드 이름을 알아보자.
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("리턴 타입과 실행된 풀 패키지 메서드명 : " + methodSignature);
		
		Method method = methodSignature.getMethod();		
		System.out.println("----------------------------------------");
		log.info("method - {}", method);
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println("type : " + object.getClass().getSimpleName());
			System.out.println("value : " + object);
		}
		System.out.println("----------------------------------------");
	}
	
	// returning 파라미터 이름과 Object 이름은 같아야 한다
	@AfterReturning(value = "myPointCut()", returning = "returnObj")
	public void myAfterReturn(JoinPoint joinPoint, Object returnObj) {
		System.out.println("return value");
		System.out.println(returnObj);
		
	}
	
	
	
	
}
