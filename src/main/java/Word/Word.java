package Word;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Word{
	public static Vector<String> list= new Vector<String>();
	public static HashMap<String,String> render= new HashMap<String,String>();
	public static HashMap<String,Integer> success= new HashMap<String,Integer>();
	
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
			
			Word.add(korean,english);
		}

		//스트림 종료
		in.close();
	}
	
	public static void add(String korean, String english){
		list.add(korean);
		render.put(korean,english);
		success.put(korean,new Integer(0));

	}
	
	public static String get(){
		Random random=new Random();
		return list.elementAt(random.nextInt(list.size()));
	}
	
	public static String render(String korean){
		return render.get(korean);
	}
	
	public static Integer getSuccess(String korean){
		return success.get(korean);
	}
	
	public static void plusSuccess(String korean){
		int num= getSuccess(korean).intValue()+1;
		success.replace(korean,new Integer(num));
	}
	
}
