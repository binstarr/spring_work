package com.example.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
	
	@Size(min = 2, max = 20)
	private String name;
	
	@Min(1)
	@Max(3)
	private int grade;

}
