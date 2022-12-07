package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	//http://localhost:8080/index.html <-- URL임
	// 주소 체계 방식이 URI
	//http://localhost:8080/api/user/get/100?name=홍길동
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		return id + "," + name;
	}
	
	//http://localhost:8080/user/post
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) {
		// 만약 aop를 사용하지 않는다면 직접 메서드 마다 코드를 추가 해야 한다.
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 핵심 로직을 만든다 (서비스를 통해 db 처리 ...)
		try {
			Thread.sleep(3500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		////////////////////////////////////////////
		stopWatch.stop();
		System.err.println("걸린 시작 측정 : " + stopWatch.getTotalTimeSeconds());
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@Timer
	@DeleteMapping("/delete")
	public void delete() throws InterruptedException {
		// db logic...
		Thread.sleep(2000);
	}

}
