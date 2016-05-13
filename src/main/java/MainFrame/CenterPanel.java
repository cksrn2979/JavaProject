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
	static Vector<JLabel> fallWordLa;
	FallingWordPanel(){
		
		setLayout(null);
		setBackground(null);
		setFont(new Font("굴림",Font.BOLD,15));
		
		fallWordLa=new Vector<JLabel>();
		
	
		Font font2 = new Font("궁서",Font.ITALIC,18);
		
		for(int i=0; i<4;i++){
			JLabel la=new JLabel(WordList.get());
			la.setSize(50,30);
			int x=100+i*30;
			int y=100+i*30;
			la.setLocation(x,y);
			fallWordLa.add(la);
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
