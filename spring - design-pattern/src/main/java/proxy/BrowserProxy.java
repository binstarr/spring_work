package proxy;

public class BrowserProxy implements IBrowser {

	private String url;
	// 추가로
	private Html html;
	
	public BrowserProxy(String url) {
		this.url = url;
	}
	
	
	@Override
	public Html show() {
		//여기에서 캐싱 기능을 추가해 볼까?
		if(html == null) {
			System.out.println("BrowserProxy loading html from : " + url);
			this.html = new Html(url);
		}
		System.out.println(">>> BrowserProxy use cache html : " + url + "<<<");
		return html;
	}

}
