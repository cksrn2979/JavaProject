package PlayPanel.CenterPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Interface.GameSet;
import MainFrame.MainFrame;
import MyDictionary.MyDictionary;
import StartFrame.StartFrame;

public class FallWordPanel extends JPanel{
	private Vector<FallWordLabel> fallWordLabelArray;
	private Vector<FallingAni> fallingAniArray;
	private FallingRun run;
	
	public Vector<FallWordLabel> getLabelArray(){return fallWordLabelArray;}
	
	public FallWordPanel(){
		setLayout(null);
		setBackground(null);
		setPreferredSize(new Dimension(500,370));
		fallingAniArray=new Vector<FallingAni>();
		fallWordLabelArray= new Vector<FallWordLabel>();
	
		run=new FallingRun(); //단어 생성 시작
		run.start();
	}
	
	public void paintComponent(Graphics g) {
		ImageIcon background = new ImageIcon("images/MainFrame/"+GameSet.getCharacter()+"/PlayPanel/CenterPanel/FallWordPanel/Background.png");	
		g.drawImage(background.getImage(), 0, 0, null);	
		setOpaque(false);
		super.paintComponent(g);
	}
	
	//떨어지는 라벨을 생성하는 쓰레드
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
			while(y<370){
				y=(int)(y+GameSet.getSpeed());
		
				la.setLocation(x, y);
						
				try {						
						sleep(500); //떨어지는 속도
				}				
				catch (InterruptedException e) {
						e.printStackTrace();
				}					
			}
				
			if(y>370 && la.getValid()==true){					
				MainFrame.mf.playPa.cp.heartGagePanel.heartGageGra.heartgage.pain(); //체력 감소
				fallWordLabelArray.remove(la); //배열에서 제거
				
				//영어 라벨이 다 떨어지면, 한글 차례로
				if(la.getLanguage()==false) 
					GameSet.setKoreanTurn();
			}	
			
			fallingAniArray.remove(this);
			stop(); //스레드 스톱
		}
	}//FallingAni 클래스 끝
}