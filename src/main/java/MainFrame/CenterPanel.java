package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

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
	
	FallingWordPanel(){		
		setLayout(null);
		setBackground(null);
		
		//n 만큼 WordLabel 생성
		FallWordLabel.add(n);
		
		Falling falling = new Falling();
		falling.start();
	}
	
	class Falling extends Thread{
		int index;
		
		public void run(){
			int x=(int)(Math.random()*300);
			int y=0;
			WordLabel la=FallWordLabel.get(0);			
			la.setLocation(x, y);
			add(la);
			while(y<400){
				y=y+10;
				la.setLocation(x, y);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
