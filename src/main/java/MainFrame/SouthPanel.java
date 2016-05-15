package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Word.FallWordLabel;
import Word.Word;

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
		String text,korean;
		
		public void keyPressed(KeyEvent e){
			//TextField에서 입력값 받아옴
			text=textInput.getText();
			
			//Enter 입력시 FallWord와 비교, TextField 클리어 
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				matchFallWord();
				textInput.setText("");
			}
		}
		
		//FallWord와 단어 비교
		void matchFallWord(){
			String renderWord=Word.render(text);
			
			//if(langage==false && renderWord!=null)
			
			
			for(int i=0; i<FallWordLabel.list.size(); i++){
				String fallWord=FallWordLabel.getText(i);
				if(fallWord.equals(text)){					
					FallWordLabel.setText(i,renderWord);
					FallWordLabel.get(i).setEnglish();
					
					if(renderWord==null){
						SuccessWordPanel.successWordList.addSuccessWord(korean,text);
						Word.plusSuccess(korean);
						FallWordLabel.remove(i);					
						langage=true;
					}
					
					else {
						korean=text;
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
