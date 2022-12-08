package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.AuthUser;

// localhost:8080/admin/test
@AuthUser
@RestController
@RequestMapping("/admin")
public class PrivateController {
	
	@GetMapping("/test")
	public String test() {
		return "통장계좌 : 1234-1234-1234-1234";
	}

}
