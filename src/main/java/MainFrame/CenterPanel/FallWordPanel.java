package MainFrame.CenterPanel;

import java.util.Vector;

import javax.swing.JPanel;

import MainFrame.Interface;
import MainFrame.MainFrame;
import MyDictionary.MyDictionary;

public class FallWordPanel extends JPanel{
	private Vector<FallWordLabel> fallWordLabelArray;
	private Vector<FallingAni> fallingAniArray;
	
	public Vector<FallWordLabel> getLabelArray(){return fallWordLabelArray;}

	FallWordPanel(){
		setLayout(null);
		setBackground(null);
		
		fallingAniArray=new Vector<FallingAni>();
		fallWordLabelArray= new Vector<FallWordLabel>();
		
		FallingRun run=new FallingRun(); //단어 생성 시작
		run.start();
	}
	
	//떨어지는 라벨을 생성하는 쓰레드
	class FallingRun extends Thread{
		public void run(){
			while(Interface.getPlay()){
				FallingAni fallingAni= new FallingAni();
				fallingAniArray.add(fallingAni);
				fallingAni.start();
				try{
					sleep(3000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//라벨 하나 하나 떨어지는 쓰레드
	class FallingAni extends Thread{	
		@SuppressWarnings("deprecation")
		public void run(){	
			//좌표값 설정
			int x=(int)(Math.random()*400);
			int y=0; 
				
			//단어를 랜덤하게 받아와 라벨 생성.
			FallWordLabel la = new FallWordLabel(MyDictionary.rand());
			
			//떨어지는 라벨 배열 추가
			fallWordLabelArray.add(la);
			
			//위치 설정
			la.setLocation(x, y);
				
			//패널에 추가
			add(la);
			
			//y<370까지 떨어트림
			while(y<370 && Interface.getPlay()){
				y=(int)(y+Interface.getSpeed());
		
				la.setLocation(x, y);
						
				try {						
					sleep(500); //떨어지는 속도
				}
				
				catch (InterruptedException e) {
						e.printStackTrace();
				}	
					
			}
				
			if(y>370 && la.getValid()==true){					
				MainFrame.mf.cp.heartGagePanel.heartGage.pain(); //체력 감소
				fallWordLabelArray.remove(la); //배열에서 제거
				
				//영어 라벨이 다 떨어지면, 한글 차례로
				if(la.getLanguage()==false) 
					Interface.setKoreanTurn();
			}	
			
			stop(); //스레드 스톱
		}
	}//FallingAni 클래스 끝
}