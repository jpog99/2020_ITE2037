package assignment04;

public class EmptyException extends Exception {
	EmptyException(){
		super("List is empty!");
	}
	
	EmptyException(String msg){
		super(msg);
	}
}
