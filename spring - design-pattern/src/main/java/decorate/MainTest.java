package decorate;

public class MainTest {

	public static void main(String[] args) {

		// 기반, 기본 클래스는 유지하되, 이 후에 필요한 녀석을 꾸밀 때 사용 !!!
		ICar audi = new Audi(1_000);
		audi.showPrice();

		// A3
		ICar audi3 = new A3(audi, "A3");
		audi3.showPrice();

		// A4
		ICar audi4 = new A4(audi, "A4");
		audi4.showPrice();

		// A4
		ICar audi5 = new A5(audi, "A5");
		audi5.showPrice();

	}

}
