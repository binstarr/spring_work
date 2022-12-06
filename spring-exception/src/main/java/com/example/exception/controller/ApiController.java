package com.example.exception.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.dto.Cat;
import com.example.exception.dto.User;

@RestController
@RequestMapping("/api")
@Validated // get 방식 일 때 우리가 선언한 validation 처리가 적용이 된다.
public class ApiController {

	// Get 과 Post 방식 일 때 예외처리가 다르다.

	@GetMapping("/user")
	public User get(@Size(min = 2, max = 10) @RequestParam(required = false) String name,
			@Min(1) @RequestParam(required = false) Integer age) {
		// (required = false) : 선택값으로 지정 , 값이 안들어와도 오류가 발생하지 않는다!

		System.out.println("여기 코드 실행 1");
		User user = new User();
		user.setName(name);
		user.setAge(age);

		// 일부러 예외 발생 처리 (null)
		int temp = 10 + age;

		return user;

	}

	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		System.out.println("여기 코드 실행 2");
		System.out.println("user : " + user);
		return user;

	}
	
	

	// 2. 특정 Controller 안에서도 직접 지정하여 예외를 담당시킬 수 있다.
	@ExceptionHandler(value = MethodArgumentNotValidException.class) // 매개변수도 같아야 동작한다.
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		System.out.println("---controller 안에서 직접 예외 처리도 가능하다---");
		System.out.println(e.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

}
