package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.AuthUserInterceptor;

import lombok.RequiredArgsConstructor;


@Configuration // 한개면 component ! 메모리 올리기
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer{

	@Autowired
	private final AuthUserInterceptor authUserInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authUserInterceptor);
//		WebMvcConfigurer.super.addInterceptors(registry);
	}


}
