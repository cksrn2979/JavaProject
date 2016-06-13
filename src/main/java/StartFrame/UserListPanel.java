package StartFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;

import Graphics.GraphicButton;
import Graphics.GraphicPanel;
import MakeUserFrame.MakeUserFrame;

public class UserListPanel extends GraphicPanel{
	public JComboBox<String> userList;
	
	UserListPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setLayout(null);
		this.setBackground(null);
		userList=new JComboBox<String>();
		userList.setSize(150,20);
		userList.setLocation(70, 10);
		userList.setBackground(Color.WHITE);
		userList.setSelectedIndex(-1);
		userList.setSelectedItem(-1);
		
		try {
			readUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(userList);
		
		String btnPath="images/StartFrame/";
		GraphicButton wordPlusBtn= new GraphicButton(btnPath,"UserPlusBtn",30,30);
		wordPlusBtn.addActionListener(new WordPlusAction());
		wordPlusBtn.setLocation(240, 5);
		
		add(wordPlusBtn);
	}
	
	class WordPlusAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				StartFrame startFrame=(StartFrame) UserListPanel.this.getTopLevelAncestor();
				new MakeUserFrame(startFrame);
		}
		
	}
	
	public void readUser() throws IOException{	
		userList.removeAllItems();
		userList.addItem(null);
		BufferedReader in = new BufferedReader(new FileReader("resources/User.txt"));
		String line = "";
		String[] spliter;
		
		while ((line = in.readLine()) != null) {
			String item;
			spliter=line.split("\t");
			item=spliter[0] +"." +"\t" + spliter[1];
			userList.addItem(item);
		}
	}

	public Object getSelectedItem() {
		return userList.getSelectedItem();
	}	
}