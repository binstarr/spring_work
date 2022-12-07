package proxy;

public class MainTest {

	public static void main(String[] args) {

		ChromeBrowser browser = new ChromeBrowser("www.naver.com");
		// 대신 HTML 생성해 주고 있다.
		// 외부에서는 browser 실행 시키기만 하면 된다.
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
		
		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		
	}

}
