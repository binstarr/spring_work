package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@WebFilter(urlPatterns = "/api/*")
public class RequestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		ContentCachingRequestWrapper wrapperReq 
		= new ContentCachingRequestWrapper((HttpServletRequest) request);
		
		ContentCachingResponseWrapper wrapperRes 
		= new ContentCachingResponseWrapper((HttpServletResponse) response);
		
		// 반드시
		chain.doFilter(wrapperReq, wrapperRes);
		System.out.println("=============Req=============");
//		System.out.println(new String(wrapperReq.getContentAsByteArray(), "UTF-8"));
		System.out.println(wrapperReq.getRequestURI());
		System.out.println(wrapperReq.getQueryString());
		
		
//		byte[] b = wrapperReq.getContentAsByteArray();
		System.out.println("=============Req=============");
		
		
		System.out.println("=============Res=============");
		System.out.println(new String(wrapperRes.getContentAsByteArray(), "UTF-8"));
		byte[] c = wrapperRes.getContentAsByteArray();
		System.out.println(c);
		System.out.println("=============Res=============");
		
		wrapperRes.copyBodyToResponse();
	
		
	}

}
