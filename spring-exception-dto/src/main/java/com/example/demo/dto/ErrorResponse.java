package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

	private int statusCode;
	private String requestUrl;
	private int code; // 1 성공, -1 실패
	private String message;
	private String resultCode; // fail, success

	private List<MyError> errorList;

}
