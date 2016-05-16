package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import GameInterface.SuccessWord;
import GameInterface.WordLabel;
import GameInterface.WordLabelArray;
import Item.Item1;
import Item.Item2;
import Item.Item3;
import Item.Item4;
import MainFrame.FallingWordPanel.FallingAniLabel;
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
		public boolean langage=true;//true = 한글 입력 차례, false = 영어 입력 차례
		String text; //입력 단어
		
		public void keyPressed(KeyEvent e){
			
			switch(e.getKeyCode()){
			case KeyEvent.VK_F1: //item1 모두 지우기
					if(Item1.getEnable()){
						Item1.call();
						langage=true; //모두 지운 후 한글 입력차례로
					}
					break;					
			case KeyEvent.VK_F2: //item2
				if(Item2.getEnable()){
					FallingWordPanel.checkItem=2;//2번 아이템 보유
					Item2.call();
				}
				break;
			case KeyEvent.VK_F3: //item3
				if(Item3.getEnable()){
					FallingWordPanel.checkItem=3;//3번 아이템 보유
					Item3.call();
				}
				break;
			case KeyEvent.VK_F4: //item4
				break;
				
			case KeyEvent.VK_ENTER: //Enter 입력시  단어 비교, 	
				text=textInput.getText(); //TextField에서 입력값 받아옴
				matchFallWord(); //단어 비교
				textInput.setText("");//textField 클리어 
			}
		}
		
		//FallWord와 단어 비교
		void matchFallWord(){
			//번역글자  :  한글 -> 영어 -> null
			String renderWord=MyDictionary.render(text);
			
			//영어 입력차례에서, 한글을 입력한 경우
			if(langage==false && renderWord!=null)
				return;			
			
			//떨어지는 라벨들과 비교
			for(int i=0; i<WordLabelArray.getNumOfLabel(); i++){
				//떨어지는 라벨의 단어
				String fallWord=WordLabelArray.getText(i);
				//Item 가진 단어 폰트 설정시 단어저장 변수
				String testItem=" ";
				
				//떨어지는 단어와 입력 단어가 같을경우
				if(fallWord.equals(text)){	
					//한글 -> 영어로, 영어-> null로
					WordLabelArray.setText(i,renderWord);
					
					//영어 입력 단계 였다면
					if(langage==false){
						//영어의 한글 값 저장
						String korean=MyDictionary.renderReverse(text);
						testItem=korean;
								
						//성공 단어에 추가
						SuccessWord.add(korean,text);
						
						//단어 성공 횟수 증가
						MyDictionary.plusSuccess(korean); 
						
						//Item확인
						switch (WordLabelArray.get(i).getHaveItem(korean)){
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
						
						//제거
						WordLabelArray.remove(i);
						
						//한글 입력차례로 변환
						langage=true;
					}
					
					else { //한글 입력 차례 였을때
						if(WordLabelArray.get(i).getHaveItem(testItem)!=0){//아이템 가진 영단어 폰트 설정
							WordLabelArray.get(i).setHaveItem_e(); 
						}
						
						else //아이템 가지지 않은 영단어
							WordLabelArray.get(i).setEnglish(); //영어로 번역된 글자를 영어 폰트로
						
						langage=false; //영어차례로 변환
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
