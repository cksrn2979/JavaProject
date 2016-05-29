package StartFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Interface.GameColor;

public class ChoiceUserPanel extends JPanel{
	JComboBox<String> userList;
	
	ChoiceUserPanel(){
		this.setPreferredSize(new Dimension(400,50));
		this.setBackground(GameColor.frame1);
		userList=new JComboBox<String>();
		userList.setPreferredSize(new Dimension(200,30));
		userList.setBackground(Color.WHITE);
					
		try {
			readUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(userList);
	}
	
	public void readUser() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/Song/git/JavaProject/User.txt"));
		String line = "";
		String[] spliter;
		
		while ((line = in.readLine()) != null) {
			String item;
			spliter=line.split("\t");
			item=spliter[0] +"." +"\t" + spliter[1];
			userList.addItem(item);
		}
	}
}