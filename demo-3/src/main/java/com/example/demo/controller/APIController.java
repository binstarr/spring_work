package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.utils.MObjectConverter;

@RestController
@RequestMapping("/api")
public class APIController {
	
	// 목표 : Response 방법에 대한 이해
	
	// text/plain
	@GetMapping("/article")
	public String article(@RequestParam String text) {
		return text;
	}
	
	// application/json
	// 외부의 요청 : request(json) --> objectMapper --> object 변환 처리 함.
	// 응답 : response(object) -> objectMapper --> json 문자 형식 변환 함
	// 결과 : Object type 리턴 하면 json으로 자동 변환 처리
	@PostMapping("/emp")
	public Employee returnSelfEmployee(@RequestBody Employee employee) {
		// --> object
		// --> json
		employee.setEmpNo("111111");
		return employee;
	}
	
	@PutMapping("/emp")
	public ResponseEntity<Employee> put(@RequestBody Employee employee) {
		employee.setEmpNo("11111");
		employee.setCode(1);
		employee.setMessage("리소스 갱신에 성공했습니다.");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	// 생성된 객체가 있다면 json 형식에 문자열을 만드는 샘플 코드를 굳이 만들어 보자.
	@GetMapping("/test1") // http://localhost:8080/api/test1
	public String makeJsonOfObject() {
		Employee employee = Employee.builder()
				.empNo("10001")
				.birthDate("1989-01-10")
				.firstName("길동")
				.lastName("창")
				.hireDate("1999-01-01")
				.gender("여")
				.build();
		
		String json = "";
		MObjectConverter<Employee> converter = new MObjectConverter();
		json = converter.objectToJson(employee);
		return json;
	}
	


}
