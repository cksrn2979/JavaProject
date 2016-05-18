package WestPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WestPanel extends JPanel{
	
	public WestPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));

		add(new SpeedPanel());
		add(new ItemPanel());
	}

}
