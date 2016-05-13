package ScoreFrame;

import javax.swing.*;
import java.awt.*;
public class NorthPanel extends JPanel{
	NorthPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(0,40));
			
		JLabel scoreMenu=new JLabel("SCORE MENU");
		scoreMenu.setFont(new Font("AvantGardeMdITCTT Bold",Font.BOLD,20));		
		setBackground(new Color(240,240,255));
		
		add(scoreMenu);
		
	}	
	
}
