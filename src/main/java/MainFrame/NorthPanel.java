package MainFrame;

import javax.swing.*;

import GameInterface.BasicInterface;

import java.awt.*;

public class NorthPanel extends JPanel{
	NorthPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(0,40));
		
		Font font = new Font("AvantGardeMdITCTT Bold",Font.BOLD,20);
		JLabel level = new JLabel("LEVEL : " + BasicInterface.level.toString());
		JLabel score = new JLabel("SCORE : " + BasicInterface.score.toString());
		
		level.setFont(font);
		score.setFont(font);
		add(level);
		add(score);
	}
}
