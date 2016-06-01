package PlayPanel.EastPanel;

import java.awt.Dimension;

import javax.swing.JPanel;

import Interface.GameColor;
import Interface.GameSet;

public class EastPanel extends JPanel{
	public InformationPanel infoPanel;
	public SuccessWordPanel successWordPanel;

	public EastPanel(){
		setBackground(GameColor.character);
		setPreferredSize(new Dimension(150,0));
		setLayout(null);
		
		String infoPath=GameSet.getPath()+"EastPanel/";
		infoPanel=new InformationPanel(infoPath,"face",130,180);
		infoPanel.setLocation(10,10);
		add(infoPanel);
		
		successWordPanel=new SuccessWordPanel();
		successWordPanel.setLocation(10,200);
		successWordPanel.setSize(130,210);
		add(successWordPanel);
	}
}
