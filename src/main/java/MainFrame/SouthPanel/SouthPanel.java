package MainFrame.SouthPanel;

import java.awt.Color;

import javax.swing.JPanel;

public class SouthPanel extends JPanel{	
	public InputTextPanel inputTextPanel; 
	
	public SouthPanel(){		
		setBackground(Color.WHITE);
		
		inputTextPanel =new InputTextPanel();
		add(inputTextPanel);
	}
}
