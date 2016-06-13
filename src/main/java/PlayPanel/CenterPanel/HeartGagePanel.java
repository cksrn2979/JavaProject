package PlayPanel.CenterPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

import Graphics.GameFontB;
import Graphics.GraphicPanel;
import MainFrame.MainFrame;

public class HeartGagePanel extends GraphicPanel{
	public HeartGage heartgage=new HeartGage();
	HeartGagePanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		heartgage=new HeartGage();
		heartgage.setFont(new GameFontB(10));
		add(heartgage);
		
	}
	
	public class HeartGage extends JProgressBar{
		int max=100;
		int min=0;
		Integer value=100;
		
		HeartGage(){
			setMinimum(min);
			setMaximum(max);
			setForeground(new Color(255,100,100));
			setStringPainted(true);
			setString(value.toString()+"%");
			setPreferredSize(new Dimension(120,17));
			setValue(value);
		
		}
	}
}
