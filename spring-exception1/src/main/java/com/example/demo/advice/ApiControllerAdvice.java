package com.example.demo.advice;

import java.util.HashMap;
import java.util.Map;
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

//1. 특정 패키지만 지정할 수 있다. basePackages = "com.example.demo.controller"
//2. 특정 컨트롤러에서 직접 처리할 수 도 있다. 
@RestControllerAdvice(basePackages = "com.example.demo.controller.ApiController")
//@ControllerAdvice // page 리턴시 예외 발생 담당 
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {

		System.out.println("--------------");
		System.out.println(e.getClass().getName());
		System.out.println(e.getLocalizedMessage());
		System.out.println("--------------");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintVilationException(ConstraintViolationException e) {

		// 예외가 발생 했을때 클라이언트에게 Json 형식으로 내려보자.
		Map<String, String> cusErrorMap = new HashMap<>();

		e.getConstraintViolations().forEach(e2 -> {

			Path path = e2.getPropertyPath();
			String message = e2.getMessage();

			try {
				StringTokenizer stringTokenizer = new StringTokenizer(path.toString(), ".");
				if (stringTokenizer.hasMoreElements()) {
					// get.name --> get, name
					stringTokenizer.nextElement(); // get --> 다음으로 이동
					// System.out.println(" :::: " + stringTokenizer.nextElement());
					cusErrorMap.put(stringTokenizer.nextElement().toString(), message);
				}
				System.out.println(path);
				System.out.println(message);
				System.out.println(e2.getInvalidValue());

			} catch (Exception e3) {
				cusErrorMap.put(path.toString(), message);
				e3.printStackTrace();
			}
		});
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cusErrorMap);
	}

	// post 예외 잡음!
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		HashMap<String, String> cusErrorMap = new HashMap<>();

		// name age 둘 다 잘못 넘어 왔다면
		e.getBindingResult().getAllErrors().forEach(e2 -> {

			FieldError fieldError = (FieldError) e2;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			// String rejectValue = (String) fieldError.getRejectedValue();
			System.out.println("fileName : " + fieldName);
			System.out.println("message : " + message);
			// System.out.println("rejectValue : " + rejectValue);
			cusErrorMap.put(fieldName, message);
		});
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cusErrorMap);
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		HashMap<String, String> cusErrorMap = new HashMap<>();
		// System.out.println("MissingServletRequestParameterException 예외 발생");
		// System.out.println(e.getLocalizedMessage());
		String field = e.getParameterName();
		cusErrorMap.put(field, field + " 는 필수 입력값 입니다.");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cusErrorMap);
	}

}