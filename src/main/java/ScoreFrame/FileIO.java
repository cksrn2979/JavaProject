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

import javax.swing.JLabel;

import Interface.GameSet;

	public class FileIO {
		
		private Vector<String> characterList= new Vector<String>(); //게임 캐릭터 목록
		private Vector<String> nameList= new Vector<String>(); //이름
		private Vector<Integer> scoreList= new Vector<Integer>(); //스코어
		private HashMap<Integer,String> gradeHashMap  = new HashMap<Integer, String>();//점수와 이름을 순위대로 기록
		private Vector<String> gradeNameList=new Vector<String>();//등수순대로 이름정렬
		
		FileIO() {
			
			try {
				readPlayer();
				writeGrade();
				
				//함수 테스트 - 콘솔창 확인
				System.out.println(" ");
				
				System.out.println("FileIO내에서 함수 호출 테스트 ");
				for(int i=0;i<gradeNameList.size();i++)
					System.out.println(i+1+"등 : "+getGradeName(i)+" 점수 : "+ getScore(getGradeName(i)));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//텍스트 파일에 저장된 데이터 읽어서 각각의 배열에 저장 
		//이긴 사람의 점수를 텍스트 파일에 저장하기 기능 없음
		void readPlayer() throws IOException{
			
			BufferedReader in = new BufferedReader(new FileReader("Score.txt"));
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
		
		void writeGrade() throws IOException{//점수 순서대로 정렬 
			
			   int i=0;
				    
			   while(i<nameList.size()){
				    	
				   	gradeHashMap.put(scoreList.get(i),nameList.get(i));
			        i++;
			        
				    }
			   
			   TreeMap<Integer,String> tm = new TreeMap<Integer,String>(gradeHashMap);
			   Iterator<Integer> iteratorKey = tm.descendingKeySet().iterator(); //키값 내림차순 정렬
			   
			   int j=0;
			   
			   while(iteratorKey.hasNext()){
				   
				   	Integer key = iteratorKey.next();
				   	gradeNameList.add(tm.get(key));
				    System.out.println(key+","+tm.get(key));
				    j++;
			   }
		}
		
		public String getGradeName(int index){//해당 등수의 이름 반환
			return gradeNameList.get(index);
		}

		public String getCharacterName(String name){//해당 이름의 캐릭터 타입 반환
			int indexNum=-1;
			int i=0;
			
			
			while(i<characterList.size())
			{
				if(nameList.get(i).equals(name))
				{
					indexNum=i;
					return characterList.get(indexNum);
				}
				i++;
			}
			return " ";
		}
		
		public Integer getScore(String name){//해당 이름의 점수 반환
			int indexNum=-1;
			int i=0;
			while(i<gradeNameList.size())
			{
				if(nameList.get(i).equals(name))
				{
					indexNum=i;
					return scoreList.get(indexNum);
				}
				i++;
			}
			return indexNum;//못찾으면 -1을 리턴 
		}
	}
