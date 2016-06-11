package PlayPanel.SouthPanel;

import java.awt.Dimension;

import javax.swing.JPanel;

import Graphics.GlobalGraphic;

public class SouthPanel extends JPanel{	
	private InputTextPanel inputTextPanel; 
	
	public SouthPanel(){		
		setBackground(GlobalGraphic.character);
		setPreferredSize(new Dimension(0,40));
		inputTextPanel =new InputTextPanel();
		add(inputTextPanel);
	}
}
