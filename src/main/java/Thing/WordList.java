package Thing;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class WordList {
	static Vector<String> wordList = new Vector<String>();
	static HashMap<String,String> wordRender= new HashMap<String,String>();
	
	public static void add(String korean, String english){
		wordList.add(korean);
		wordRender.put(korean,english);
	}
	
	public static String get(){
		Random random=new Random();
		return wordList.elementAt(random.nextInt(wordList.size()));
	}
	
	public static String render(String korean){
		return wordRender.get(korean);
	}
	
}
