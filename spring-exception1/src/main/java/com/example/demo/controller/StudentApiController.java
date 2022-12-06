package com.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;

@RestController //1번
@RequestMapping("/student") //2번
@Validated
public class StudentApiController {
	
	// 순서와 상관없이 get mapping
	@GetMapping("/select")
	public ResponseEntity<Student> requestStudent(@Min(100) @RequestParam Long id){
		
		// id 값을 받아서 Service 객체에게 요청
		Student student = new Student();
		student.setName("아무개");
		student.setGrade(1);
		return null;
	}

	//3번
	@PostMapping("/insert")
	public ResponseEntity<Student> post(@Valid @RequestBody Student student){
		System.out.println(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
	
	 // post 넘겨 받을 시 필수 키 값을 아예 보내지 않았을 경우
	// 기본 값 key = value 
	@PostMapping("/insert2")
	public ResponseEntity<Student> post2(String name, Integer grade){
		System.out.println("name : " + name);
		System.out.println("grade : " + grade);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	
}
