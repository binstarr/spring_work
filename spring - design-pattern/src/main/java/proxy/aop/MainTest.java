package proxy.aop;

import java.util.concurrent.atomic.AtomicLong;

public class MainTest {

	public static void main(String[] args) {
		// 시간을 측정 하고 싶다.
		
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();
		
		AopBrowser aopBrowser =
				new AopBrowser("www.naver.com", 
						() -> {
							System.out.println("먼저 실행 할꺼지롱!!!");
							start.set(System.currentTimeMillis());
						}, 
						() -> {
							long nowTime = System.currentTimeMillis();
							end.set(nowTime - start.get());
							System.out.println("-----------------------------");
						}
					);
		
		aopBrowser.show();
		System.out.println(end.get());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		aopBrowser.show();
		System.out.println(end.get());
		aopBrowser.show();
		System.out.println(end.get());

		aopBrowser.show();
		System.out.println(end.get());

		aopBrowser.show();
		System.out.println(end.get());
		aopBrowser.show();
		System.out.println(end.get());
		aopBrowser.show();
		System.out.println(end.get());


	}

}
