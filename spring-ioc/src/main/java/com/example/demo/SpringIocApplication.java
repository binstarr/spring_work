package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocApplication.class, args);
		
//		MyBase64Encoder base64Encoder = new MyBase64Encoder(); <-- 개발자가 직접 생성
		ApplicationContext context = ApplicationContextProvider.getContext();
		
		String myUrl = "www.naver.com/q=우리 이길까????";
		
		MyBase64Encoder base64Encoder = context.getBean(MyBase64Encoder.class);
		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
		
		MyEncoder encoder = context.getBean(MyEncoder.class);
		
		// 변경 처리 set 메서드 (set을 사용해서 내가 선택 가능)
		encoder.setIEncoder(base64Encoder);
		
		String result = encoder.encode(myUrl);
		System.out.println(result);
	}

}
