package MyDictionary;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyDictionary{
	private static Vector<String> list= new Vector<String>(); //목록
	private static HashMap<String,String> render= new HashMap<String,String>(); //번역
	private static HashMap<String,Integer> success= new HashMap<String,Integer>(); //성공횟수
	
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
			//읽어온 라인데이터를 "탭"단위로 자름
			spliter = line.split("\t");
			
			korean=spliter[0];
			english=spliter[1];
			
			MyDictionary.add(korean,english);
		}

		//스트림 종료
		in.close();
	}
	
	//단어의 갯수 리턴
	public static int getNumOfWord(){
		return list.size();
	}
	
	//문자열
	public static void add(String korean, String english){
		list.add(korean);
		render.put(korean,english);
		success.put(korean,new Integer(0));

	}
	
	//index 단어를 리턴
		public static String getWord(int index){
			return list.get(index);
	}

	//랜덤하게 단어를 리턴
	public static String rand(){
		Random random=new Random();
		return list.elementAt(random.nextInt(list.size()));
	}
	
	
	//한글을 영어로 번역
	public static String render(String korean){
		return render.get(korean);
	}
	
	//영어를 한글로 번역
	public static String renderReverse(String english){
		 for(String s : render.keySet()) {
			    if (render.get(s).equals(english))
			    	return s;
			}
		 return null;
	}
	
	//성공횟수를 받아옴
	public static Integer getSuccess(String korean){
		return success.get(korean);
	}
	
	//성공횟수 +1
	public static void plusSuccess(String korean){
		success.replace(korean,getSuccess(korean).intValue()+1);
	}
	
}
