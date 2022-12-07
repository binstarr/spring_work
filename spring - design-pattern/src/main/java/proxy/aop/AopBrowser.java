package proxy.aop;

import proxy.Html;
import proxy.IBrowser;


// 관점 지향
// 전처리
// 실제 동작 메서드 ....
// 후처리

public class AopBrowser implements IBrowser {
	
	private String url;
	private Html html;
	private Runnable before;
	private Runnable after;
	
	public AopBrowser(String url, Runnable before, Runnable after) {
		this.url = url;
		this.before = before;
		this.after = after;
	}
	
	@Override
	public Html show() {

		before.run();
		
		if(html == null) {
			System.out.println("BrowserProxy loading html from : " + url);
			this.html = new Html(url);
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
		}
		
		System.out.println(" AopBrowser use cache html : " + url );
		
		after.run();
		return html;
	}

}
