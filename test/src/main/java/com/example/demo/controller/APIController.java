package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스는 Rest API를 처리하는 Controller 사용하겠다는 선언
@RequestMapping("/api") // http:localhost:8080/api
public class APIController {
	
	@GetMapping("/bins") // http:localhost:8080/api/bins
	public String hello() {
		return "Hello i'm seongbin";
	}
}
