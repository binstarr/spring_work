package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

	@NotBlank(message = "이름을 입력해주세요")
	private String name;
	@Max(value = 100,  message = "죄송하지만 100세는 가입 불가입니다.")
	@Min(value = 10,  message = "중학생 이후 가입 가능합니다.")
	private int age;
	@Email
	private String email;
	@Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식이 틀렸습니다.")
	private String phoneNumber;
	
}
