package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Employee;

// page 응답할 때 사용 (html, jsp, time leaf, mustch)
@Controller
public class PageController {
	
	@GetMapping("/main")
	public String main() {
		// view resolver 동작으로 파일을 찾아 준다.
		return "main.html";
	}
	
	// 만약 json 리턴 하고 싶다면
	@ResponseBody
	@GetMapping("/employee")
	
	public Employee employee() {
		var emp = new Employee();
		emp.setEmpNo("100");
		emp.setFirstName("티모");
		emp.setLastName("mike");
		return emp;
	}

}
