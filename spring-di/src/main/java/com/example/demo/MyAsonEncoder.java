package com.example.demo;

public class MyAsonEncoder implements IEncoder{

	@Override
	public String encode(String msg) {
		String result = "AAA : " + msg + "AAAAAAAAAA";
		return result;
	}

}
