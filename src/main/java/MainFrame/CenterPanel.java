package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import GameInterface.WordLabel;
import GameInterface.WordLabelArray;
import MainFrame.HeartGagePanel.HeartGage;
import MyDictionary.MyDictionary;
import ScoreFrame.ScoreFrame;


class HeartGagePanel extends JPanel{
	HeartGage heartgage;
	HeartGagePanel(){
		setBackground(null);
		heartgage= new HeartGage();
		
		add(new JLabel("HEART "));
		add(heartgage);		
	}
	
	class HeartGage extends JProgressBar{
		Integer heart=new Integer(100);
		HeartGage(){
			setMinimum(0);
			setMaximum(100);
			setForeground(new Color(255,100,100));
			setStringPainted(true);
			setString(heart.toString()+"%");
			setValue(heart.intValue());
		}
		
		void getPain(){
			heart=heart-10;
			setValue(heart);
			setString(heart.toString()+"%");
			
			if(heart==0)
				new ScoreFrame();	
				
		}
	}
}

class FallingWordPanel extends JPanel{
	int speed=500;
	FallingAni[] fallingAni = new FallingAni[10];
	
	FallingWordPanel(){		
		setLayout(null);
		setBackground(null);

		for(int i=0; i<10;i++){
			fallingAni[i]=new FallingAni();
		}
		
		FallingPlay a=new FallingPlay();
		a.start();
	}
	
	class FallingPlay extends Thread{
		public void run(){
			for(int i=0; i<10; i++){
				fallingAni[i].start();
				try{
					sleep(3000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
			}
			}
		}
	}
	
	class FallingAni extends Thread{
		public void run(){
			while(true){
				int x=(int)(Math.random()*300);
				int y=0;
				String korean=MyDictionary.rand();
				WordLabel la = new WordLabel(korean);
				WordLabelArray.add(la);
				la.setLocation(x, y);
				add(la);
				while(y<400){
					y=y+10;
					la.setLocation(x, y);
					try {
						sleep(speed);
					}
					catch (InterruptedException e) {
							e.printStackTrace();
					}	
				}
				if(la.getLocation().getY()==400)
					
				
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
