package MfSouthPanel;

import java.awt.Color;

import javax.swing.JPanel;

public class SouthPanel extends JPanel{	
	public SouthPanel(){
		setBackground(Color.WHITE);
		add(new InputTextPanel());
	}
}
