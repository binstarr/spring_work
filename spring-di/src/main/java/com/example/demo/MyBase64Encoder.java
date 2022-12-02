package com.example.demo;

import java.util.Base64;

public class MyBase64Encoder implements IEncoder{

	@Override
	public String encode(String msg) {
		
		// encode : 숫자를 문자로 , decode : 문자를 숫자로
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
	
	// 테스트 코드
	public static void main(String[] args) {
		MyBase64Encoder base64Encoder = new MyBase64Encoder();
		String msg = base64Encoder.encode("안녕하세요");
		System.out.println(msg);
	}

	
	
}
