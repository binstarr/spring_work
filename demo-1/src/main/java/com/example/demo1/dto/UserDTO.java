package com.example.demo1.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserDTO {

	private String name;
	private int age;
	
	@JsonProperty("phone_number")
	private String phoneNumber; // 원래 코드가 >>phone_number 일때 자바에서는 phoneNumber로 쓰고싶을때 

}
