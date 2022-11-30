package com.example.demo1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dto.RequestPutDTO;
import com.example.demo1.dto.ResponsePutDTO;

@RestController
@RequestMapping("/api")
public class PutApiController {
	
	@PutMapping("/put1")
	public ResponsePutDTO put1(@RequestBody RequestPutDTO reqDto) {
		// 연산 과정...
		// DB 접근해서 처리 했다는 가정
		ResponsePutDTO result = new ResponsePutDTO();
		
		//RequestPutDTO 를 확인하고 JSON 형식을 설계 하고 응답 까지 처리 하시오 
		result.setName(reqDto.getName());
		result.setAge(reqDto.getAge());
		result.setCarList(reqDto.getCarList());
		result.setStatusCode(200);
	
		return result;
	}
	
	//http://localhost:8080/api/put2/100
	@PutMapping(path = "/put2/{age}")
	public String put2(@RequestBody RequestPutDTO reqDto, @PathVariable int age) {
		return reqDto.toString() + "..." + age;
	}
	
	
}
