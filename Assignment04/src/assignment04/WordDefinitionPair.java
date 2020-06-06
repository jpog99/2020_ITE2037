package assignment04;

public class WordDefinitionPair {
	private String word;
	private String definition;
	
	WordDefinitionPair(String word, String definition){
		this.word = word;
		this.definition = definition;
	}
	
	public String getWord(){
		return word;
	}
	public String getDef(){
		return definition;
	}
	public void setWord(String word){
		this.word = word;
	}
	public void setDef(String definition){
		this.definition = definition;
	}
	
}
