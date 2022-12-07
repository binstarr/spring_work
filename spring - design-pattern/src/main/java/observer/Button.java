package observer;

public class Button implements IButtonListener{

	String name;
	private IButtonListener buttonListener;
	
	public Button(String name) {
		this.name = name;
	}
	
//	public void click(String message) {
//		buttonListener.clickEvent(message);
//	}
	
	@Override
	public void clickEvent(String message) {
		buttonListener.clickEvent(message);
	}
	
	public void addListener(IButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}

}
