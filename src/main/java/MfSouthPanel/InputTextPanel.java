package MfSouthPanel;
import java.lang.Math;
import java.util.Random;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import GameInterface.MyDictionary;
import MfCenterPanel.FallWordLabel;
import MfCenterPanel.FallWordLabelArray;
import MfEastPanel.SuccessWordPanel;
import MfWestPanel.ItemPanel;

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
				if(ItemPanel.getItem(0).getEnable()){
					ItemPanel.getItem(0).call();
					ItemPanel.getItemBtn(0).setEnabled(false);
					langage=true;
				}
				break;		
				
			case KeyEvent.VK_F2: //item2
				if(ItemPanel.getItem(1).getEnable())
					ItemPanel.getItem(1).call();
				
				break;	
				
			case KeyEvent.VK_F3: //item3			
				if(ItemPanel.getItem(2).getEnable())
					ItemPanel.getItem(2).call();
					ItemPanel.getItemBtn(2).setEnabled(false);
					
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
			String renderWord=MyDictionary.render(text); 	//번역글자  :  한글 -> 영어 -> null
			
			if(langage==false && renderWord!=null) //영어 입력차례에서, 한글을 입력한 경우
				return;			
						
			for(int index=0; index<FallWordLabelArray.getNumOfLabel(); index++){ //떨어지는 라벨들과 비교
				FallWordLabel la=FallWordLabelArray.get(index);
				String fallWord=FallWordLabelArray.getText(index); //떨어지는 라벨의 단어				
				
				if(fallWord.equals(text)){ //떨어지는 단어와 입력 단어가 같을경우	 					
					FallWordLabelArray.setText(index,renderWord); //한글 -> 영어로, 영어-> null로
					
					if(langage==false)
						InputEnglish(la);  //영어 입력 단계 였다면	 				
					else 
						InputKorean(la);	 //한글 입력 차례 였을때	
					
					break;
				}
			}
		}
		
		void InputEnglish(FallWordLabel la){
			
			//영어의 한글 값 저장
			String korean=MyDictionary.renderReverse(text);
					
			//성공 단어에 추가
			SuccessWordPanel.successWordTable.add(korean,text);
			
			//단어 성공 횟수 증가
			MyDictionary.plusSuccess(korean);
			
			//무효한 숫자로
			la.setValid(false);
			
			//Item확인, 생성
			if(la.getHaveItem())

			{
				Random random=new Random();
				int num=random.nextInt(4);//0-3 아이템 번호 제공
				
				while(ItemPanel.getItem(num).getEnable()==true){
					num=random.nextInt(4);
				}
				
				ItemPanel.getItem(num).setEnable(true);
				ItemPanel.getItemBtn(num).setEnabled(true);
				
			}
	
			//제거
			FallWordLabelArray.remove(la);
			
			//한글 입력차례로 변환
			langage=true;
		}
		
		void InputKorean(FallWordLabel la){	
			if(la.getHaveItem())
				la.setHaveItem_e();
			else
				la.setEnglish(); 	//아이템 가지지 않은 영단어
			
			langage=false; //영어차례로 변환
		}
	}
}