package Dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class UserDictionary {
	private Vector<String> list = new Vector<String>(); // 목록
	private HashMap<String, String> render = new HashMap<String, String>(); // 번역
	private HashMap<String, Integer> success = new HashMap<String, Integer>(); // 성공횟수

	public UserDictionary(String user) {
		try {
			readWordBasicDictionary(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에서 단어를 입력시킴
	private void readWordBasicDictionary(String user) throws IOException {
		
		// readline 읽을 String변수
		String line = "";

		// 파일 데이터 저장 스트림

		BufferedReader in = new BufferedReader(new FileReader("resources/UserDictionary/" + user + "_Dictionary.txt"));
	
		// 데이터 잘라줄 객체
		String[] spliter;

		String korean;
		String english;
		String successcount;

		// 파일 라인별로 읽음
		while ((line = in.readLine()) != null) {
			// 읽어온 라인데이터를 "탭"단위로 자름
			spliter = line.split("\t");

			korean = spliter[0];
			english = spliter[1];
			successcount = spliter[2];
			this.add(korean, english, Integer.parseInt(successcount));
		}

		// 스트림 종료
		in.close();
	}

	public void writeWordUserDictionary(String user) throws IOException {
		
		String korean;
		String english;
		String successcount;

		BufferedWriter out = new BufferedWriter(new FileWriter("resources/UserDictionary" + user + "_Dictionary.txt"));
		String s;

		for (int i = 0; i < list.size(); i++) {
			korean = getWord(i);
			english = render(korean);
			successcount = getSuccess(korean).toString();

			s = korean + "\t" + english + "\t" + successcount;
			out.write(s);
			out.newLine();
		}
		out.close();
	}

	// 단어의 갯수 리턴
	public int getNumOfWord() {
		return list.size();
	}
	
	public String getWord(int i){
		return list.get(i);
	}
	// 단어를 입력
	public void add(String korean, String english, Integer successcount) {
		list.add(korean);
		render.put(korean, english);
		success.put(korean, successcount);

	}

	// 랜덤하게 단어를 리턴
	public String rand() {
		Random random = new Random();
		return list.elementAt(random.nextInt(list.size()));
	}

	// 한글을 영어로 번역
	public String render(String korean) {
		return render.get(korean);
	}

	// 영어를 한글로 번역
	public String renderReverse(String english) {
		for (String s : render.keySet()) {
			if (render.get(s).equals(english))
				return s;
		}
		return null;
	}

	// 성공횟수를 받아옴
	public Integer getSuccess(String korean) {
		return success.get(korean);
	}

	// 성공횟수 +1
	public void plusSuccess(String korean) {
		success.replace(korean, getSuccess(korean).intValue() + 1);
	}

}
