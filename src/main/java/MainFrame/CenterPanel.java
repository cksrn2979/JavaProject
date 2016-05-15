package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import Thing.WordLabel;
import Word.FallWordLabel;


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
	int n=1; //Label 갯수
	FallingWordPanel(){		
		setLayout(null);
		setBackground(null);
		
		//n 만큼 WordLabel 생성
		FallWordLabel.add(n);
		
		addFallWordLabel();		
	}
	
	void addFallWordLabel(){
		for(int i=0; i<n;i++){
			//i순서만큼 단어 받아옴
			WordLabel la=FallWordLabel.get(i);
			int x=(int)Math.random()*300;
			int y=(int)Math.random()*300;
			la.setLocation(x, y);
			add(la);			
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
