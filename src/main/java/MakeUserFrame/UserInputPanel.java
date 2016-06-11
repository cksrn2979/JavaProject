package MakeUserFrame;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

class UserInputPanel extends JPanel{
	JTextField userInput;
	
	UserInputPanel(){
		setLayout(new FlowLayout());
		setBackground(null);			
		userInput= new JTextField("",15);
		add(userInput);
	}
}