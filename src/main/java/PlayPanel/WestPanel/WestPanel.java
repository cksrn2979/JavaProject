package PlayPanel.WestPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Interface.GameColor;

public class WestPanel extends JPanel{
	public SpeedPanel speedPanel;
	public ItemPanel itemPanel;
	
	public WestPanel(){
		setBackground(GameColor.character);
		setPreferredSize(new Dimension(150,0));
		
		speedPanel = new SpeedPanel();
		itemPanel = new ItemPanel();
		
		add(speedPanel);
		add(itemPanel);
	}

}
