package PlayPanel.EastPanel;

import javax.swing.JLabel;

import Graphics.GameFontB;
import Graphics.GraphicPanel;
import MainFrame.MainFrame;

public class InformationPanel extends GraphicPanel{
	JLabel userla;
	
	InformationPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setBackground(null);
		setLayout(null);
		setLocation(10,40);
		
		userla=new JLabel();
		userla.setFont(new GameFontB(17));
		userla.setSize(200,20);
		userla.setLocation(30,10);	
		add(userla);	

	}
	
	public void setUserText(String user){userla.setText(user);}
}