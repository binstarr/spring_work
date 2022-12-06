package com.example.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cat {
	
	@Size(min =1, max =5)
	private String name;
	
	@NotBlank
	private String type;
	
	@Max(20)
	private int age;
}
