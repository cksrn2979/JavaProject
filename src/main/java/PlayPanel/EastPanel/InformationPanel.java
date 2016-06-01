package PlayPanel.EastPanel;

import javax.swing.JLabel;

import Graphics.GraphicPanel;
import Interface.GameFontB;
import Interface.GameSet;

class InformationPanel extends GraphicPanel{
	InformationPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setBackground(null);
		setLayout(null);
		setLocation(10,40);
		
		JLabel la=new JLabel(GameSet.getUser());
		la.setFont(new GameFontB(17));
		la.setSize(200,20);
		la.setLocation(40,10);	
		add(la);		
	

	}
}