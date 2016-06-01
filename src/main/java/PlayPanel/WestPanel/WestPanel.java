package PlayPanel.WestPanel;

import java.awt.Dimension;

import javax.swing.JPanel;

import Interface.GameColor;
import Interface.GameSet;

public class WestPanel extends JPanel{
	public SpeedPanel speedPanel;
	public ItemPanel itemPanel;
	
	public WestPanel(){
		setBackground(GameColor.character);
		setPreferredSize(new Dimension(150,0));
		String itemPath=GameSet.getPath()+"WestPanel/";
		String speedPath=GameSet.getPath()+"WestPanel/";
		speedPanel = new SpeedPanel(speedPath,"SpeedPanel",130,150);
		itemPanel = new ItemPanel(itemPath,"ItemPanel",130,240);
		
		add(speedPanel);
		add(itemPanel);
	}

}
