package assignment04;

import java.util.ArrayList;
import java.util.Iterator;

public class DictionaryArray implements Dictionary {
	private ArrayList<WordDefinitionPair> DicList;

	DictionaryArray() {
		DicList = new ArrayList<WordDefinitionPair>();
	}
	
	public String getDictList(){
		int num=1;
		String list = "";
		Iterator it = DicList.iterator();
		while(it.hasNext()) {
			WordDefinitionPair temp = (WordDefinitionPair) it.next();
			list += num + ". Word : " + temp.getWord() + "\tDefinition : " + temp.getDef() +"\n";
			num++;
		}
		return list;
	}
		
	
	@Override
	public boolean isEmpty() {
		return DicList.isEmpty();
	}

	@Override
	public void insertEntry(String word, String definition) throws AlreadyExistsInDictException {
			Iterator it = DicList.iterator();
			while(it.hasNext()) {
				WordDefinitionPair temp = (WordDefinitionPair) it.next();
				if(temp.getWord().equals(word)) throw new AlreadyExistsInDictException();
			}
			
			WordDefinitionPair pair = new WordDefinitionPair(word, definition);
			DicList.add(pair);
	}

	@Override
	public void getDefinition(String word) throws EmptyException, NotInDicException{
			if (DicList.isEmpty()) throw new EmptyException();
			Iterator it = DicList.iterator();
			while(it.hasNext()) {
				WordDefinitionPair temp = (WordDefinitionPair) it.next();
				if(temp.getWord().equals(word)) {
					System.out.println("\"" + word + "\" means: " + temp.getDef());
					return;
				}
			}
			throw new NotInDicException();
	}

	@Override
	public void removeWord(String word) throws EmptyException, NotInDicException {
		if (DicList.isEmpty()) throw new EmptyException();
		Iterator it = DicList.iterator();
		while(it.hasNext()) {
			WordDefinitionPair temp = (WordDefinitionPair) it.next();
			if(temp.getWord().equals(word)) {
				DicList.remove(temp);
				return;
			}
		}
		throw new NotInDicException();
	}

	@Override
	public void printWords() throws EmptyException {
		if (DicList.isEmpty()) throw new EmptyException();
		Iterator it = DicList.iterator();
		int num=1;
		while(it.hasNext()) {
			WordDefinitionPair temp = (WordDefinitionPair) it.next();
			System.out.println(num + ". " +temp.getWord());
			num++;
		}
		
	}

	@Override
	public void printAll() throws EmptyException {
		if (DicList.isEmpty()) throw new EmptyException();
		Iterator it = DicList.iterator();
		while(it.hasNext()) {
			WordDefinitionPair temp = (WordDefinitionPair) it.next();
			System.out.println("*************************************");
			System.out.println("Word : " + temp.getWord() + "\nDefinition : " + temp.getDef());
		}
	}
	
}
