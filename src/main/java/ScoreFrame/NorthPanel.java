package ScoreFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel{
	NorthPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(0,40));
			
		JLabel scoreMenu=new JLabel("SCORE MENU");
		scoreMenu.setFont(new Font("고딕",Font.BOLD,20));		
		setBackground(new Color(240,240,255));
		
		add(scoreMenu);
		
	}	
	
}
