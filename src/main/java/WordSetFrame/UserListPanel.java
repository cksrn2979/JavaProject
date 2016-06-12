package WordSetFrame;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;

import Graphics.GraphicPanel;

public class UserListPanel extends GraphicPanel {
	public JComboBox<String> userList;

	UserListPanel(String path, String FILENAME, int width, int height) {
		super(path, FILENAME, width, height);
		setLayout(null);
		this.setBackground(null);

		userList = new JComboBox<String>();
		userList.setSize(150, 20);
		userList.setLocation(70,10);
		userList.setBackground(Color.WHITE);
	
		userList.addItemListener(new UserListItemListener());
		
		try {
			readUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(userList);
	}

	public void readUser() throws IOException {
		userList.addItem(null);
		BufferedReader in = new BufferedReader(new FileReader("resources/User.txt"));
		String line = "";
		String[] spliter;

		while ((line = in.readLine()) != null) {
			String item;
			spliter = line.split("\t");
			item = spliter[0] + "." + "\t" + spliter[1];
			userList.addItem(item);
		}
		
	}
	
	class UserListItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem()!=null){
				String userInfo=(String)e.getItem();
				String[] spliter;
				spliter=userInfo.split("\t");
				String user= spliter[1];
				
				WordSetFrame topFrame=(WordSetFrame)UserListPanel.this.getTopLevelAncestor();
				topFrame.wordListPanel.wordListTable.loadDictionary(user);
			}				
		}
	}
}