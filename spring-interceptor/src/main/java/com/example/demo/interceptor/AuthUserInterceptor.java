package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.example.demo.annotation.AuthUser;

// 인터셉터를 우리가 직접 구현해 보자.
@Component
public class AuthUserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String uriStr = request.getRequestURI();
		String queryString = request.getQueryString(); // ?tencoid=tenco... <- 
		System.out.println("queryString : " + queryString);
		// 어노테이션 있는지 체크 하자
		boolean validAuthUser = checkAnnotation(handler, AuthUser.class);
		System.out.println("체~~~~~~~~~~~~크 : " + validAuthUser);
		if(validAuthUser) {
			if(queryString == null) {
				return false;
			}
			// 한단계 더 체크
			if(queryString.equals("tecoId=teco")) {
				return true;
			}else {
				return false;
			}
		}

//		return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}
	
	// Object handler 핸들러로  authUser 어노테이션이 있는지 확인
	private boolean checkAnnotation(Object handler, Class clazz) {
		
		//리소스를 요청시 무조건 허용
		if(handler instanceof ResourceHttpRequestHandler) {
			System.out.println("리소스 요청 class" + clazz.getName());
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if(null != handlerMethod.getMethodAnnotation(clazz) ||
				null != handlerMethod.getBeanType().getAnnotation(clazz)) {
			System.out.println("어노테이션 체크 class " + clazz.getName());
			return true;
		}
		return false;
	}
	
}
