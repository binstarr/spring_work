package com.example.demo.controller;

import java.security.KeyStore.Entry;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;

//해당 Class는 Rest API를 처리하는 Controller 사용하겠다 선언
//컴포넌트 스캔 어노테이션을 확인해서 IoC 넣어준다.
@RestController
@RequestMapping("/api") // http://localhost:9090/api
public class APIController2 {

	// Query Parameter 방식의 이해
	
	// ? <-- 부터가 query parameter 주소이다
	// search.naver.com/search.naver
	// ?where=nexearch
	// &sm=top_hty
	// &fbm=1
	// &ie=utf8
	// &query=월드컵
	
	// 쿼리 파라미터는 보통 검색할 때 많이 사용한다.
	// Get 맵핑
	// http://localhost:9090/api/query-param1?name=홍길동&email=a@nate.com
	// 쿼리 파람으로 값을 보낼 때 --> 더 추가 해서 보내는 것은 상관이 없다.
	// 받을 때 : 매개 변수에 선언한 값이 없이 보내게 된다면 Error page를 만날꺼야
	@GetMapping("/query-param1")
	public String queryParam1(@RequestParam String name, @RequestParam String email) {
		System.out.println("맨 앞은 pathvariable");
		System.out.println("쿼리 파람에 대한 인자값 처리");
		return "<p>name="+name+","+email+"</p>";
	}
	
	// http://localhost:9090/api/query-param2?name=홍길동&email=a@nate.com&age=100&context=반가우이
	@GetMapping("/query-param2")
	public String queryParam2(@RequestParam Map<String, String> data) {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		// entrySet을 사용하면 key, value 구조를 뽑을 수 있다.
		// 그 후 forEach로 하나씩 뽑느다
		data.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});
		
		return stringBuffer.toString();
	}
	
	// DTO를 활용해서 받는 방법 !! - 보통 실무에서 많이 사용하는 방식 
	// : map을 사용하면 연산을 더 해야하기 때문에 코드가 더 길어지고 귀찮아진다. (StringBuffer, entry 등)
	// http://localhost:9090/api/query-param3?name=홍길동&email=a@nate.com&age=100&context=반가우이
	// DTO 설계 방식 때는 앞에 아무것도 적으면 안된다.
	// 						 <<<< 주의사항 >>>>
	// 1. @RequestParam을 적으면 안된다 DTO의 속성을 필요한 것만 사용이 가능하다.
	// 2. 요청에 추가적인 부분이 더 많아도 상관 없고 dto 속성에 없는 녀석이 있어도 상관 없다.
	// Message Converter 가 알아서 동작하고 있다.
	@GetMapping("/query-param3")
	public String queryParam3(UserDTO user) {
		
		return user.toString();
	}

}
