package assignment04;

public class AlreadyExistsInDictException extends Exception {
	AlreadyExistsInDictException(){
		super("Word already exist in dictionary!");
	}
	
	AlreadyExistsInDictException(String msg){
		super(msg);
	}
}
