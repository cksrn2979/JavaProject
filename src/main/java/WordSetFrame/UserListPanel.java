package WordSetFrame;

import java.awt.Color;
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
		

		try {
			readUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(userList);
	}

	public void readUser() throws IOException {
		userList.removeAllItems();
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
}