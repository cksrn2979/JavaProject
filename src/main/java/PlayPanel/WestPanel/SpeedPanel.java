package PlayPanel.WestPanel;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;

import Graphics.GameFontB;
import Graphics.GlobalGraphic;
import Graphics.GraphicPanel;
import MainFrame.MainFrame;

public class SpeedPanel extends GraphicPanel{
	private JLabel speedLa=new JLabel();
	
	SpeedPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);	
		setBackground(null);
		setLayout(null);		
		setLocation(0,30);
		
		speedLa.setFont(new GameFontB(20));
		speedLa.setLocation(40,45);
		speedLa.setSize(120,50);
		speedLa.setForeground(GlobalGraphic.basic);
		add(speedLa);
		
	}
	
	public void setSpeedText(String speed){speedLa.setText(speed);}
	
}

