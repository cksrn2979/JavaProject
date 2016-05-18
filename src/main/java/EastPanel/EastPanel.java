package EastPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EastPanel extends JPanel{
	public EastPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		InformationPanel info=new InformationPanel();
		add(info);
		
		SuccessWordPanel successWordPanel=new SuccessWordPanel();
		add(successWordPanel);
		
		WordSetPanel wordSet=new WordSetPanel();
		add(wordSet);	

	}
}
