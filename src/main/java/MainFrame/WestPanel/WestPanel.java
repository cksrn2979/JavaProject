package MainFrame.WestPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WestPanel extends JPanel{
	public SpeedPanel speedPanel;
	public ItemPanel itemPanel;
	
	public WestPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));
		
		speedPanel = new SpeedPanel();
		itemPanel = new ItemPanel();
		
		add(speedPanel);
		add(itemPanel);
	}

}
