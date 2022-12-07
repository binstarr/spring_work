package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
	
	// http://localhost:8080/api/get/{11}?name={이순신}
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		return "id : " + id + ", name : " + name; 
	}
	
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) {

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
