package ScoreFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import PlayPanel.PlayPanel;

	public class FileIO {
		public PlayPanel p;
		public static List<UserInfo> Users = new ArrayList<UserInfo>();
		public static UserInfo myUser;
		int fileLineNumber;
		
		FileIO(PlayPanel p) {
			this.p=p;
			try {
				readPlayer();
				setMyUser();
				sortGrade();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
		void readPlayer() throws IOException{
			
			BufferedReader in = new BufferedReader(new FileReader("resources/Score.txt"));

			String s;
			Integer score;
			
			while ((s = in.readLine()) != null) {
				String[] split = s.split("\t");
				if(split.length<2){
					Users.add(new UserInfo(split[0],split[1],0));
				}
				else 
					Users.add(new UserInfo(split[0],split[1],Integer.parseInt(split[2])));
				
				fileLineNumber++;
				
			}

			in.close();
		}
		
		public void setMyUser() throws IOException{
			BufferedReader in = new BufferedReader(new FileReader("resources/Score.txt"));
			String s=" ";
			int i=0;
			while((s = in.readLine()) != null){
				i++;
				if(fileLineNumber==i)
				{
					String[] split = s.split("\t");
					myUser=new UserInfo(split[0],split[1],Integer.parseInt(split[2]));
					System.out.println(i+"============"+split[0]+split[1]);
				}
			}
		
			in.close();
		}
		
		void sortGrade() throws IOException{//점수 순서대로 정렬 
			Collections.sort(Users, new NoDescCompare());
		}
	
		static class NoDescCompare implements Comparator<UserInfo> {
			public int compare(UserInfo arg0, UserInfo arg1) {
				return arg0.getScore() > arg1.getScore() ? -1 : arg0.getScore() < arg1.getScore() ? 1:0;
			}
		}
		
}