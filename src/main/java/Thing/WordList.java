package Thing;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
	public static Vector<String> wordList= new Vector<String>();
	public static HashMap<String,String> wordRender= new HashMap<String,String>();
	public static HashMap<String,Integer> wordSuccess= new HashMap<String,Integer>();
	
	private static BufferedReader in;

	public static void inWordFromFile() throws IOException{
		
		//readline 읽을 String변수
		String line = "";
		
		//파일 데이터 저장 스트림
		in = new BufferedReader(new FileReader("WORDLIST.txt"));
		
		//데이터 잘라줄 객체
		String[] spliter;
		
		String korean;
		String english;
		
		//파일 라인별로 읽음
		while ((line = in.readLine()) != null) {
			//읽어온 라인데이터를 구문자대로 자름
			spliter = line.split("\t");
			
			korean=spliter[0];
			english=spliter[1];
			
			WordList.add(korean,english);
		}

		//스트림 종료
		in.close();
	}
	
	public static void add(String korean, String english){
		wordList.add(korean);
		wordRender.put(korean,english);
		wordSuccess.put(korean,new Integer(0));

	}
	
	public static String get(){
		Random random=new Random();
		return wordList.elementAt(random.nextInt(wordList.size()));
	}
	
	public static String render(String korean){
		return wordRender.get(korean);
	}
	
	public static Integer getSuccess(String korean){
		return wordSuccess.get(korean);
	}
	
	public static void plusSuccess(String korean){
		int num= getSuccess(korean).intValue()+1;
		wordSuccess.replace(korean,new Integer(num));
	}
	
}
