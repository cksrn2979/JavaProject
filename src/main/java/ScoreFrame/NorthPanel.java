package ScoreFrame;

import Graphics.GraphicPanel;
import Interface.GameColor;

public class NorthPanel extends GraphicPanel{
	NorthPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setBackground(GameColor.basic);		
	}	
	

}
