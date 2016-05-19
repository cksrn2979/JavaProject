package MainFrame.EastPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EastPanel extends JPanel{
	public InformationPanel infoPanel;
	public SuccessWordPanel successWordPanel;
	public WordSetPanel wordSetPanel;
	
	public EastPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		infoPanel=new InformationPanel();
		add(infoPanel);
		
		successWordPanel=new SuccessWordPanel();
		add(successWordPanel);
		
		wordSetPanel=new WordSetPanel();
		add(wordSetPanel);	

	}
}
