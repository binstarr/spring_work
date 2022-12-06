package com.example.demo.dto;

import lombok.Data;

@Data
public class MyError {
	
	private String field;
	private String message;
	private Object invalidValue;
	

}
