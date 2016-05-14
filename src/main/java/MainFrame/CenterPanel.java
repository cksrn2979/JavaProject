package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import Thing.WordLabel;
import Thing.WordList;

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
	static Vector<WordLabel> fallWordLabel;
		
	FallingWordPanel(){
		
		setLayout(null);
		setBackground(null);
		
		fallWordLabel=new Vector<WordLabel>();
		
		for(int i=0; i<4;i++){
			WordLabel wla=new WordLabel(WordList.get());
			int x=100+i*30;
			int y=100+i*50;
			wla.setLocation(x,y);
			fallWordLabel.add(wla);
			add(wla);
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
