package com.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		System.out.println("111111111111111111111");
		return user;
	}
	
	@GetMapping("/user")
	public User get(@Size(min =2, max = 10)@RequestParam String name, @Min(value = 2)@RequestParam Integer age){
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}
}
