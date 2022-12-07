package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerApo {
	
	@Pointcut(value = "execution(* com.example.demo.controller..*.*(..))")
	public void startTimer() {
	}
	
	@Pointcut(value = "@annotation(com.example.demo.anno.Timer)")
	private void endTimer() {
		
	}
	
	@Around("startTimer() && endTimer()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = proceedingJoinPoint.proceed();
		System.out.println("result : " + result);
		
		stopWatch.stop();
		System.out.println("걸린 시간 : " + stopWatch.getTotalTimeSeconds());
		
	}

}
