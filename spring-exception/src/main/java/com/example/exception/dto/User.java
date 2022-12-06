package com.example.exception.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

	@NotEmpty
	@Size(min = 2, max = 10)
	private String name;
	@Min(1)
	private int age;
}
