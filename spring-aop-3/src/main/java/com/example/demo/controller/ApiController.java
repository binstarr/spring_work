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

import com.example.demo.anno.Timer;
import com.example.demo.dto.User;

@RestController
@RequestMapping("/api/user")
public class ApiController {

	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name){
		return id + "," + name;
	}
	
	@Timer
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) throws InterruptedException{
		Thread.sleep(3000);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}
