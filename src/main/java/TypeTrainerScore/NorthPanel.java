package TypeTrainerScore;

import javax.swing.*;
import java.awt.*;
public class NorthPanel extends JPanel{
NorthPanel(){
	setBackground(new Color(240,240,255));
	setPreferredSize(new Dimension(0,40));
	
	Font font = new Font("AvantGardeMdITCTT Bold",Font.BOLD,20);
	
	JLabel scoreMenu=new JLabel("SCORE MENU");
	scoreMenu.setFont(font);		
	setBackground(new Color(240,240,255));
	add(scoreMenu);
	
}	
	
}
