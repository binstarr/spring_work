package com.example.exception.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cat {
	
	@Size(min = 1, max = 5)
	private String name;

	@NotBlank
	private String type;

	@Max(20)
	private int age;

}

//@GetMapping("/cat")
//public Cat get(@Size(min=1, max = 5) @RequestBody(required =  false ) String name,
//			   @NotBlank @RequestBody String type, @Max(20) @RequestBody int age) {
//	
//	Cat cat = new Cat();
//	cat.setName("모네");
//	cat.setType("코숏");
//	cat.setAge(10);
//	
//	return cat;
//}