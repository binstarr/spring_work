package com.example.exception.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice //RestController에 대한 예외를 담당
//1. 특정 패키지만 지정하여 예외를 담당시킬 수 있다.
@RestControllerAdvice(basePackages = "com.example.exception.controller") 

//@ControllerAdvice // 페이지 리턴 시 예외 발생 담당
//public class GlobalControllerAdvice { //전체 일 때 클래스명
	public class ApiControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		
		System.out.println("--------------------------------------------");
		System.out.println("에러이름:" + e.getClass().getName());
		System.out.println("메시지:" + e.getLocalizedMessage());
		System.out.println("--------------------------------------------");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class) //매개변수도 같아야 동작한다.
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e){
		
		System.out.println("--------ConstraintViolationException 예외발생-------");
		System.out.println(e.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class) //매개변수도 같아야 동작한다.
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		
		System.out.println("--------MethodArgumentNotValidException 예외발생-------");
		System.out.println(e.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	
}
