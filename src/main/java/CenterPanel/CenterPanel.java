package CenterPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import GameInterface.BasicInterface;
import GameInterface.MyDictionary;
import ScoreFrame.ScoreFrame;





public class CenterPanel extends JPanel{
	
	public CenterPanel(){
		
		setBackground(Color.WHITE);
		Border CenterBorder= BorderFactory.createEtchedBorder();
		setBorder(CenterBorder);
		setLayout(new BorderLayout());
		add(new HeartGagePanel(),BorderLayout.NORTH);
		add(new FallingWordPanel(),BorderLayout.CENTER);
		
	}
}