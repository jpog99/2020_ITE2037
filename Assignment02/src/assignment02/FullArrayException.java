package assignment02;

public class FullArrayException extends Exception {
	public FullArrayException() {
		super("List is full!\nTry to expand...\nHow much will it expands?");
	}
	
	public FullArrayException(String message) {
		super(message);
	}
}
