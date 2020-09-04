package selfTest;

import java.util.ArrayList;
import java.util.Collections;

public class GenericManager <T extends Comparable>{
	private ArrayList<T> cList;

	public GenericManager() {
		cList = new ArrayList<T>();
	}
	
	public void add(T a) {
		cList.add(a);
	}
	
	public void sort() {
		Collections.sort(cList);
	}
	
	public String find(T a) {
		String temp = "";
		for(T b:cList) 
			if(b.equals(a)) temp+=b.toString();
		return temp;
	}
	
	
	public String toString() {
		String temp = "";
		for(T b:cList)
			temp += b.toString();
		return temp;
	}
}
