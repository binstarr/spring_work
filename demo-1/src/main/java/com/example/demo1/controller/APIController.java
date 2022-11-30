package com.example.demo1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class APIController {
	
	// 시나리오
	// REST API Client
	// JSON 형식으로 보낸다 {"name" : "홍길동", "age" : 10}
	// http://localhost:8080/api/post
	@PostMapping("/post")
	public String post1(@RequestBody Map<String, Object> reqBody) {
		
		StringBuffer stringBuffer = new StringBuffer();
		reqBody.entrySet().forEach(e -> {
			System.out.println("key : " + e.getKey() + "value : " + e.getValue());
			stringBuffer.append(e.getKey() + " : " + e.getValue() + "<br>");
		});
		
		return stringBuffer.toString();
	}
	
	@PostMapping("/post1")
	public String post1(@RequestBody UserDTO dto) {
		return dto.toString();
	}

}
