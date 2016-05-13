package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Thing.WordList;

public class SouthPanel extends JPanel{
	JTextField textInput;
	String text;
	
	
	SouthPanel(){
		setBackground(Color.WHITE);
		textInput = new JTextField("",20);
		textInput.addKeyListener(new InputTextListener());
		textInput.requestFocus();
		add(textInput);
		Button btn1= new Button("Input");
		btn1.setBackground(Color.WHITE);
		add(btn1);		
	}
	
	class InputTextListener extends KeyAdapter{
		boolean langage=true;
		
		public void keyPressed(KeyEvent e){
			text=textInput.getText();
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				matchFallWord();
				textInput.setText("");
			}
		}
		
		void matchFallWord(){
			Vector<JLabel> fallWordLabel=FallingWordPanel.fallWordLa;
			String renderWord=WordList.render(text);
			
			if(langage==false && renderWord!=null)return;
			
			for(int i=0; i<fallWordLabel.size(); i++){
				String fallWord=fallWordLabel.elementAt(i).getText();
				if(fallWord.equals(text)){					
					fallWordLabel.elementAt(i).setText(renderWord);
					if(renderWord==null){
						fallWordLabel.remove(fallWordLabel.elementAt(i));
						langage=true;
					}
					else 
						langage=false;
					break;
				}//if문 끝
			}//for문 끝
		}//matchFallWord() 끝
	}
	


}
