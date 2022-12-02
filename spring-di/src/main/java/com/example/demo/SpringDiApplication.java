package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiApplication.class, args);
		
		MyBase64Encoder base64Encoder = new MyBase64Encoder();
		UrlEncoder urlEncoder = new UrlEncoder();
		MyAsonEncoder myAsonEncoder = new MyAsonEncoder();
		/////////////////////////////////////////// 메모리에 다 올라갔음
		String mUrl = "www.naver.com/q?오늘축구이기나?";
		MyEncoder encoder = new MyEncoder(urlEncoder);
		

		
		String result = encoder.encode(mUrl);
		System.out.println(result);
		
	}

}
