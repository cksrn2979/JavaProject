package MainFrame;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel{
	NorthPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(0,40));
		
		Font font = new Font("AvantGardeMdITCTT Bold",Font.BOLD,20);
		JLabel level = new JLabel("LEVEL :  20    ");
		JLabel score = new JLabel("SCORE :  100   ");
		
		level.setFont(font);
		score.setFont(font);
		add(level);
		add(score);
	}
}
