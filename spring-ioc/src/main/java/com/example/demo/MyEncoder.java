package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyEncoder {

	private IEncoder iEncoder;

	// DI 의존 주의 받는다.
	public MyEncoder(@Qualifier("myUrlEncoder") IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}

	public void setIEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}

	// 기능 encoding
	public String encode(String message) {
		return iEncoder.encode(message);
	}

}
