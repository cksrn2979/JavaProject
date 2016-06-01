package PlayPanel.CenterPanel;

import java.awt.Color;
import java.util.Vector;

import Graphics.GraphicPanel;
import Interface.GameSet;
import MainFrame.MainFrame;
import MyDictionary.MyDictionary;

public class CenterPanel extends GraphicPanel{
	public HeartGagePanel heartGagePa;
	
	private Vector<FallWordLabel> fallWordLabelArray;
	private Vector<FallingAni> fallingAniArray;
	private FallingRun run;
	
	public Vector<FallWordLabel> getLabelArray(){return fallWordLabelArray;}
	
	public CenterPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setLayout(null);
		
		fallingAniArray=new Vector<FallingAni>();
		fallWordLabelArray= new Vector<FallWordLabel>();
	
		run=new FallingRun(); //단어 생성 시작
		run.start();
		
		String heartGraPath=GameSet.getPath()+"CenterPanel/";
		heartGagePa = new HeartGagePanel(path,"HeartGageGra",200,30);
		heartGagePa.setLocation(150,10);
		add(heartGagePa);
			
	}
	
	class FallingRun extends Thread{
		public void run(){
			while(true){
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
			int y=50; 
				
			//단어를 랜덤하게 받아와 라벨 생성.
			FallWordLabel la = new FallWordLabel(MyDictionary.rand());
			
			//떨어지는 라벨 배열 추가
			fallWordLabelArray.add(la);
			
			//위치 설정
			la.setLocation(x, y);
				
			//패널에 추가
			add(la);
						
			//y<370까지 떨어트림
			while(y<400){
				y=(int)(y+GameSet.getSpeed());
		
				la.setLocation(x, y);
						
				try {						
						sleep(500); //떨어지는 속도
				}				
				catch (InterruptedException e) {
						e.printStackTrace();
				}					
			}
				
			if(y>400 && la.getValid()==true){					
				MainFrame.mf.playPa.cp.heartGagePa.heartgage.pain(); //체력 감소
				fallWordLabelArray.remove(la); //배열에서 제거
				
				//영어 라벨이 다 떨어지면, 한글 차례로
				if(la.getLanguage()==false) 
					GameSet.setKoreanTurn();
			}	
			
			fallingAniArray.remove(this);
			this.resume();
			
			//stop(); //스레드 스톱
		}
	}//FallingAni 클래스 끝
		
}
