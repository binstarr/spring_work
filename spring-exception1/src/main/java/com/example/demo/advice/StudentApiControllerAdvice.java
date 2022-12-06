package com.example.demo.advice;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//1번
@RestControllerAdvice(basePackages = "com.example.demo.controller.") 
public class StudentApiControllerAdvice {
	
	//2 번 전체 exception 클래스!!
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> myException(Exception exception){
		
		System.out.println("--------------------------------------");
		System.out.println(exception.getClass().getName());
		System.out.println(exception.getMessage());
		System.out.println("--------------------------------------");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FAIL");
	}
	
	// 3번 post 넘겨 받을 시 잘못된 args 값이 넘어 온다면 처리 방법 
	@ExceptionHandler(value = MethodArgumentNotValidException.class) // MethodArgumentNotValidException <-- 여기선 이것만 다룸
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		
		//6번
		HashMap<String, String> errorMap = new HashMap<>();
		// 5번
		// name, age에 잘못 되어 있는거 다 여기로 들어옴
		// List<ObjectErrors> ! <-- 리스트 타입이라서 반복문으로 하나씩 뺀다
		e.getBindingResult().getAllErrors().forEach(e2 -> {
			 // 7번 예외 항목이 여기서 뽑아낼 수 있다.
			FieldError fieldError = (FieldError) e2;
			String fieldName = fieldError.getField(); // name? age? 어디서 잘못된건지 한개씩 반복문 돌면서 담긴다.
			String message = fieldError.getDefaultMessage();
			// 8번 사용자에게 보여줄 위의 정보를 가공한다. (name : 뭐가 잘못 되었어)
			errorMap.put(fieldName, message);
		});
		
		System.out.println("여기 들어오나요?"); //4번 확인
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}
	
	// get 요청시 선언된 valid 값이 잘못 들어왔을 경우
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?>  constraintViolationException(ConstraintViolationException exception ){
		HashMap<String, String> errorMap = new HashMap<>();
		
		// request.id <-- 이렇게 담김
		exception.getConstraintViolations().forEach(e2 -> {
			Path path = e2.getPropertyPath();
			StringTokenizer tokenizer = new StringTokenizer(path.toString(), ".");
			if(tokenizer.hasMoreElements()) {
				String preName = tokenizer.nextToken();
				
				String lastName = tokenizer.nextToken();
				String message = e2.getMessage();
				
				//getInvalidValue : 잘못된 사용자의 입력값
				System.out.println("getInvalidValue : " + e2.getInvalidValue());
				errorMap.put(lastName, message);
				
			}
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}
	
	@ExceptionHandler(value =  MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		HashMap<String, String> errorMap = new HashMap<>();
		
		
		System.out.println("여기 들어오나요?");
		System.out.println("a :" + e.getParameterName());
		
		errorMap.put(e.getParameterName(), e.getParameterName() + "는 필수 값입니다.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	
	}

}
