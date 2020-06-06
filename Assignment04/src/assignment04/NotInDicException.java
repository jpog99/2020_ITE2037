package assignment04;

public class NotInDicException extends Exception{
	NotInDicException(){
		super("This word not exist in dictionary!");
	}
	
	NotInDicException(String msg){
		super(msg);
	}
}
