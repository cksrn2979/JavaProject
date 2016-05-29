package ScoreFrame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import Interface.GameSet;

	public class FileIO {
		
		private static Vector<String> characterList= new Vector<String>(); //게임 캐릭터 목록
		private static Vector<String> nameList= new Vector<String>(); //이름
		private static Vector<Integer> scoreList= new Vector<Integer>(); //스코어
		private static HashMap<Integer,String> hashMap  = new HashMap<Integer, String>();//점수와 이름을 순위대로 기록
		
		FileIO() {
			
			try {
				readPlayer();
//				writePlayer();
				writeGrade();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public static void readPlayer() throws IOException{//Score 저장된 파일 읽어서 각각의 배열에 저장
			BufferedReader in = new BufferedReader(new FileReader("C:/Users/Song/git/JavaProject/Score.txt"));
				String gameCharacter;	
				String name;
				String score;
				int i=0;
				String s;
				  
				while ((s = in.readLine()) != null) {
				String[] split = s.split("\t");
				 
				gameCharacter = split[0]; 
				name = split[1]; 
				score=split[2];
				
				characterList.add(i,gameCharacter);
				nameList.add(i,name);
				scoreList.add(i,Integer.parseInt(score));
				i++;
				}

			in.close();
		
		}
		public static void writeGrade() throws IOException{//점수 순서대로 정렬 
			
				    int i=0;
				    
				    while(i<nameList.size()){
				    	
				    hashMap.put(scoreList.get(i),nameList.get(i));
			        i++;
			        
				    }
				    TreeMap<Integer,String> tm = new TreeMap<Integer,String>(hashMap);
				    Iterator<Integer> iteratorKey = tm.descendingKeySet().iterator(); //키값 내림차순 정렬
				    
				    while(iteratorKey.hasNext()){
				     Integer key = iteratorKey.next();
				     System.out.println(key+","+tm.get(key));
				    }
		}
	}
