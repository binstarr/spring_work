package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//해당 Class는 Rest API를 처리하는 Controller 사용하겠다 선언
//컴포넌트 스캔 어노테이션을 확인해서 IoC 넣어준다.
@RestController 
@RequestMapping("/api") // http://localhost:9090/api
public class APIController {
	
	@GetMapping("/hello") // http://localhost:9090/api/hello
	public String hello() {
		System.out.println("http://localhost:9090/api/hello 여기로 왔네요");
		return "Hello Spring boot World";
	}

}
