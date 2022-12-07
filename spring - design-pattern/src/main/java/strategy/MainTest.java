package strategy;

public class MainTest {

	
	public static void main(String[] args) {
		Encoder encoder = new Encoder();
		
		Base64Strategy base64Strategy = new Base64Strategy();
		NormalStrategy normalStrategy = new NormalStrategy();
		
		encoder.setEncodingStrategy(base64Strategy);
		encoder.getMessage("안녕");
		encoder.setEncodingStrategy(normalStrategy);
		encoder.getMessage("안녕");
		
		System.out.println(encoder.getMessage("안녕"));
	}
}
