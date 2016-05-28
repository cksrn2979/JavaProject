package PlayPanel.EastPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Interface.GameColor;

public class EastPanel extends JPanel{
	public InformationPanel infoPanel;
	public SuccessWordPanel successWordPanel;
	public WordSetPanel wordSetPanel;
	
	public EastPanel(){
		setBackground(GameColor.character);
		setPreferredSize(new Dimension(150,0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		infoPanel=new InformationPanel();
		add(infoPanel);
		
		successWordPanel=new SuccessWordPanel();
		add(successWordPanel);
	}
}
