package com.example.demo;

public class MyEncoder {

	private IEncoder iEncoder;
	
	// DI 의존 주의 받는다.
	public MyEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	
	// 기능 encoding
	public String encode(String message) {
		return iEncoder.encode(message);
	}
	
	
}
