package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

	@Pointcut(value = "execution(* com.example.demo.controller..*.*(..))")
	public void cut() {
	}

	@Pointcut(value = "@annotation(com.example.demo.anno.Timer)")
	private void checkTimer() {
	}

	@Around("cut() && checkTimer()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// 시간 측정
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		// 실행 전
		Object result = proceedingJoinPoint.proceed();
		// 메서드 실행 완료
		stopWatch.stop();
		System.out.println("total time : " + stopWatch.getTotalTimeSeconds());

	}

}
