package MainFrame.CenterPanel;

import javax.swing.JPanel;

import MainFrame.MainFrame;
import MyDictionary.MyDictionary;

public class FallWordPanel extends JPanel{
	static int checkItem=0;
	
	//떨어지는 라벨들의 갯수
	private int n=10; 
	FallingAniLabel[] fallingAniLabel = new FallingAniLabel[n];
	
	FallWordPanel(){
		setLayout(null);
		setBackground(null);
		
		FallingPlay a=new FallingPlay();
		a.start();
	}
	
	//떨어지는 라벨을 생성하는 쓰레드
	class FallingPlay extends Thread{
		public void run(){
			while(MainFrame.getPlay()){
				FallingAniLabel fallAni= new FallingAniLabel();
				fallAni.start();
				try{
					sleep(7000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//라벨 하나 하나 떨어지는 쓰레드
	class FallingAniLabel extends Thread{
	
		public void run(){
			
			while(MainFrame.getPlay()){
				//좌표값 설정
				int x=(int)(Math.random()*400);
				int y=0; 
				
				//단어를 랜덤하게 받아와 라벨 생성.
				FallWordLabel la = new FallWordLabel(MyDictionary.rand());
				
				//떨어지는 라벨 모음에 라벨 추가
				FallWordLabelArray.add(la);
				
				//위치 설정
				la.setLocation(x, y);
				
				//패널에 추가
				add(la);
				
				//y<380까지 떨어트림
				while(y<380 && MainFrame.getPlay()){
					
					y=(int)(y+MainFrame.getSpeed()); 
					
					la.setLocation(x, y);
						
					try {						
						sleep(500); //떨어지는 속도
					}
					
					catch (InterruptedException e) {
							e.printStackTrace();
					}	
					
				}
				
				if(y>380 && la.getValid()==true){
					HeartGagePanel.heartGage.pain();
					FallWordLabelArray.remove(la);
				}				
			}
		}
	
	}
}