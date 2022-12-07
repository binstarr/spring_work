package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@PostMapping("/post")
	public User post(@RequestBody User user) {
		return user;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity post() {
		System.out.println("delete 정상 동작");
		return ResponseEntity.ok().build();
	}
}
