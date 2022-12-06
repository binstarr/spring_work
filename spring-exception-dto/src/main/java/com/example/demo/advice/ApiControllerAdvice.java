package com.example.demo.advice;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.MyError;

@RestControllerAdvice(basePackages = "com.example.demo.controller.")
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {

		System.out.println("--------------");
		System.out.println(e.getClass().getName());
		System.out.println(e.getLocalizedMessage());
		System.out.println("--------------");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest req) {
		ArrayList<MyError> myErrors = new ArrayList<>();

		ex.getBindingResult().getAllErrors().forEach(e -> {
			// FieldError로 다운캐스팅 하면 엄청 편하다.
			FieldError fieldError = (FieldError) e;
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			Object rejectValue = fieldError.getRejectedValue();

			MyError error = new MyError();
			error.setField(fieldName);
			error.setMessage(message);
			error.setInvalidValue(rejectValue);

			myErrors.add(error);
		});
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(myErrors); // errorList
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("잘못된 요청 입니다.");
		errorResponse.setCode(-1);
		errorResponse.setResultCode("FAIL");
		errorResponse.setRequestUrl(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
		ArrayList<MyError> errorList = new ArrayList<>();

		e.getConstraintViolations().forEach(e2 -> {
			Path path = e2.getPropertyPath();
			StringTokenizer stringTokenizer = new StringTokenizer(path.toString(), ".");
			if (stringTokenizer.hasMoreElements()) {
				String preName = stringTokenizer.nextToken();
				String lastName = stringTokenizer.nextToken();
				System.out.println("preName : " + preName);
				System.out.println("lastName : " + lastName);
				MyError error = new MyError();
				error.setField(lastName);
				error.setMessage(e2.getMessage());
				error.setInvalidValue(e2.getInvalidValue());
				errorList.add(error);
			}
			System.out.println("path : " + path);
		});

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorList);
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		ArrayList<MyError> errorList = new ArrayList<>();
		MyError error = new MyError();
		
		error.setField(e.getParameterName());
		error.setMessage(e.getMessage());

		errorList.add(error);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}