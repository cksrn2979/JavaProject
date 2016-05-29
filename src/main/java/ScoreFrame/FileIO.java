package ScoreFrame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import Interface.GameSet;

	public class FileIO {
		
		private static Vector<String> characterList= new Vector<String>(); //게임 캐릭터 목록
		private static Vector<String> nameList= new Vector<String>(); //이름
		private static Vector<Integer> scoreList= new Vector<Integer>(); //스코어
		
		FileIO() {
			
			try {
				readPlayer();
				writePlayer();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		public static void readPlayer() throws IOException{
			BufferedReader in = new BufferedReader(new FileReader("C:/Users/Song/git/JavaProject/User.txt"));
				String gameCharacter;	
				String name;
				Integer score;
				int i=0;
				String s;
				  
				while ((s = in.readLine()) != null) {
				String[] split = s.split("\t");
				 
				gameCharacter = split[0]; 
				name = split[1]; 
				score = GameSet.getScore();
				
				characterList.add(i,gameCharacter);
				nameList.add(i,name);
				scoreList.add(i,score);
				i++;
				}

			in.close();
		
		}
		
		public static void writePlayer() throws IOException{
		
				String gameCharacter;	
				String name;
				Integer score;
				
				BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/Song/git/JavaProject/Score.txt"));
				String s;
				
				for(int i=0; i<characterList.size();i++){
					gameCharacter=characterList.get(i);
					name=nameList.get(i);
					score=scoreList.get(i);
					
					System.out.println(name+score.toString());
					
					s=gameCharacter+"\t"+name+"\t"+score.toString();		 
					out.write(s); out.newLine();
				}
				out.close();
		}
					
		public static void add(String gameCharacter, String name,Integer score){
				characterList.add(gameCharacter);
				nameList.add(name);
				scoreList.add(score);
				
		}
		

}
