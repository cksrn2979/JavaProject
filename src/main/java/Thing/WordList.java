package Thing;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class WordList {
	Vector<String> wordList = new Vector<String>();
	HashMap<String,String> wordRender= new HashMap<String,String>();
	
	public void add(String korean, String english){
		wordList.add(korean);
		wordRender.put(korean,english);
	}
	
	public String get(){
		Random random=new Random();
		return wordList.elementAt(random.nextInt(wordList.size()));
	}
	
	public String render(String korean){
		return wordRender.get(korean);
	}
	
}
