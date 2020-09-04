package selfTest;

public class TooMuchStuffException extends Exception {

	private int inputNumber;
	
	public TooMuchStuffException(int num) {
		super("Too much stuff!");
		inputNumber = num;
	}
	
	public TooMuchStuffException() {
		super("Too much stuff!");
	}
	
	public TooMuchStuffException(String m) {
		super(m);
	}
	
	public int getNumber() {
		return inputNumber;
	}
	
}
