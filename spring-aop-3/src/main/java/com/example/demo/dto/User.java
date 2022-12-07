package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	
	private Long id;
	private String email;
	private String pw;

}
