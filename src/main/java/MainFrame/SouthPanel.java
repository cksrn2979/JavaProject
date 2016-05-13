package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SouthPanel extends JPanel{
	JTextField textInput;
	String text;
	
	SouthPanel(){
		setBackground(Color.WHITE);
		textInput = new JTextField("",20);
		textInput.addKeyListener(new InputTextListner());
		textInput.requestFocus();
		add(textInput);
		Button btn1= new Button("Input");
		btn1.setBackground(Color.WHITE);
		add(btn1);		
	}
	
	class InputTextListner extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			text=textInput.getText();
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				System.out.println(text);
				textInput.setText("");
			}
		}
	}
}
