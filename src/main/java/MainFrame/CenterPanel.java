package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import GameInterface.BasicInterface;
import GameInterface.WordLabel;
import GameInterface.WordLabelArray;
import MyDictionary.MyDictionary;


class HeartGagePanel extends JPanel{
	HeartGagePanel(){
		setBackground(null);
		
		JProgressBar heart= new JProgressBar();
		heart.setMinimum(0);
		heart.setMaximum(5);
		heart.setForeground(new Color(255,100,100));
		heart.setStringPainted(true);
		heart.setString(new String("80%"));
		heart.setValue(4);
		add(new JLabel("HEART "));
		add(heart);
		
	}
}

class FallingWordPanel extends JPanel{
	static int checkItem=0;
	
	//떨어지는 라벨들의 갯수
	private int n=10; 
	FallingAniLabel[] fallingAniLabel = new FallingAniLabel[n];
	
	FallingWordPanel(){		
		setLayout(null);
		setBackground(null);
		
		//초기화
		for(int i=0; i<10;i++){
			fallingAniLabel[i]=new FallingAniLabel();
		}
		
		FallingPlay a=new FallingPlay();
		a.start();
	}
	
	//떨어지는 라벨을 생성하는 쓰레드
	class FallingPlay extends Thread{
		public void run(){
			for(int i=0; i<10; i++){
				fallingAniLabel[i].start();
				try{
					sleep(1000);
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
			
			while(BasicInterface.play){
				//좌표값 설정
				int x=(int)(Math.random()*400);
				int y=0; 
				
				//단어를 랜덤하게 받아와 라벨 생성.
				WordLabel la = new WordLabel(MyDictionary.rand());
				
				//떨어지는 라벨 모음에 라벨 추가
				WordLabelArray.add(la);
				
				//위치 설정
				la.setLocation(x, y);
				
				//패널에 추가
				add(la);
				int o=0;
				//y<400까지 떨어트림
				while(y<400){
					if(checkItem==3)//3번 느리게 아이템
					{	o++;
						if(o==15)checkItem=0;
						y=y+5;
					}
					else
						y=y+10; 
					
					la.setLocation(x, y);
						
					try {
						if(checkItem==2)//2번 잠깐 멈추기 아이템
						{
							sleep(5000);
							checkItem=0;
						}
						
						sleep(BasicInterface.speed); //떨어지는 속도
					}
					catch (InterruptedException e) {
							e.printStackTrace();
					}	
					
				}
				
				WordLabelArray.remove(la);
			}
		}
	
	}
}

public class CenterPanel extends JPanel{
	
	CenterPanel(){
		
		setBackground(Color.WHITE);
		Border CenterBorder= BorderFactory.createEtchedBorder();
		setBorder(CenterBorder);
		setLayout(new BorderLayout());
		add(new HeartGagePanel(),BorderLayout.NORTH);
		add(new FallingWordPanel(),BorderLayout.CENTER);
		
	}
}