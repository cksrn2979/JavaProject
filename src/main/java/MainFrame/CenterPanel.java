package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import MyDictionary.MyDictionary;
import Thing.FallWordLabel;
import Thing.WordLabel;


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
	int n=100; //Label 갯수
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
				FallWordLabel.add(la);
				la.setLocation(x, y);
				add(la);
				while(y<400){
					y=y+10;
					la.setLocation(x, y);
					try {
						sleep(500);
					}
					catch (InterruptedException e) {
							e.printStackTrace();
					}	
				}
				
				FallWordLabel.remove(la);
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
