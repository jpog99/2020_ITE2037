package assignment04;

public interface Dictionary {
	public boolean isEmpty();
	public void insertEntry(String word, String definition) throws AlreadyExistsInDictException;
	public void getDefinition(String word) throws EmptyException, NotInDicException;
	public void removeWord(String word) throws EmptyException, NotInDicException;
	public void printWords() throws EmptyException;
	public void printAll() throws EmptyException;
}
