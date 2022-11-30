package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// Path Variable 방식의 이해

	// 예전 방식
	// http://localhost:9090/api/myInfo1 --> GET, POST, PUT, DELETE 사용 가능
	@RequestMapping("/myInfo1")
	public String myInfo1() {
		return "<p>홍길동</p>";
	}

	@RequestMapping(path = "/myInfo2", method = RequestMethod.GET) // (GET, POST, PUT, DELETE)
	public String myInfo2() {
		return "<p>야스오</p>";
	}

	// 요즘 사용하는 방식으로 path variable 이해하자
	// GET 맵핑에 대한 이해
	@GetMapping("/path-variable") // 대문자보다 하이폰 사용하는게 권장사항
	public String pathVariable() {
		return "path : ..";
	}

	// http://localhost:9090/api/path-variable/{홍길동}
	// http://localhost:9090/api/path-variable/{야스오}
	// {야스오} <-- 값을 내 메서드 안으로 받는 방법
	@GetMapping("/path-variable/{name}") // 대문자보다 하이폰 사용하는게 권장사항
	public String pathVariable2(@PathVariable String name) {
		return "path : " + name;
	}

	// {야스오} <-- 값을 내 메서드 안으로 받는 방법
	@GetMapping("/path-variable/{name}/{age}") // 대문자보다 하이폰 사용하는게 권장사항
	public String pathVariable3(@PathVariable String name, @PathVariable int age) {
		return "path : " + name + ", 나이는 " + age + "살 입니다.";
	}

	// 종종 주소 설계에 넘어오는 인자 key 값과 메서드 안에 인자 이름이 같을 경우 !!!
	@GetMapping("/path-variable4/{name}/{age}") // 대문자보다 하이폰 사용하는게 권장사항
	public String pathVariable4(@PathVariable(name = "name") String reqName, @PathVariable int age, String name) {
		return "path : " + reqName + ", 나이는 " + age + "살 입니다.";
	}

}
