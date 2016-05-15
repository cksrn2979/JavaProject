package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import GameInterface.SuccessWord;
import GameInterface.WordLabelArray;
import Item.Item1;
import Item.Item2;
import Item.Item3;
import Item.Item4;
import MyDictionary.MyDictionary;

class InputTextPanel extends JPanel{
	JTextField textInput;
	
	InputTextPanel(){
		textInput = new JTextField("",20);
		textInput.addKeyListener(new InputTextListener());
		textInput.requestFocus();
		add(textInput);
		
		Button btn1= new Button("Input");
		btn1.setBackground(Color.WHITE);
		add(btn1);	
	}
	
	class InputTextListener extends KeyAdapter{
		//true = 한글 입력 차례, false = 영어 입력 차례
		boolean langage=true;
		String text;
		
		public void keyPressed(KeyEvent e){
			
			switch(e.getKeyCode()){
			case KeyEvent.VK_F1:
					if(Item1.getEnable())
						Item1.call();
					langage=true;
					break;					
			case KeyEvent.VK_F2:
				break;
			case KeyEvent.VK_F3:
				break;
			case KeyEvent.VK_F4:
				break;
				
			case KeyEvent.VK_ENTER: //Enter 입력시 FallWord와 비교, TextField 클리어 	
				//TextField에서 입력값 받아옴
				text=textInput.getText();
				matchFallWord();
				textInput.setText("");
			}
		}
		
		//FallWord와 단어 비교
		void matchFallWord(){
			String renderWord=MyDictionary.render(text);
			if(langage==false && renderWord!=null)
				return;			
			for(int i=0; i<WordLabelArray.list.size(); i++){
				String fallWord=WordLabelArray.getLabelText(i);
				if(fallWord.equals(text)){					
					WordLabelArray.setLabelText(i,renderWord);		
					if(langage==false){
						String korean=MyDictionary.renderReverse(text);
						SuccessWord.add(korean,text);
						
						switch (WordLabelArray.getLabel(i).getHaveItem(korean)){
						case 0:break;
						case 1:
							Item1.setEnable(true);break;
						case 2:
							Item2.setEnable(true);break;
						case 3:
							Item3.setEnable(true);break;
						case 4:
							Item4.setEnable(true);break;						
						}
						
						WordLabelArray.remove(i);					
						langage=true;
					}
					
					else {
						WordLabelArray.getLabel(i).setEnglish();
						langage=false;
					}
					
					break;
				}//if문 끝
			}//for문 끝
		}//matchFallWord() 끝
	}
}

class SouthPanel extends JPanel{
	
	SouthPanel(){
		setBackground(Color.WHITE);
		add(new InputTextPanel());
	}
}
