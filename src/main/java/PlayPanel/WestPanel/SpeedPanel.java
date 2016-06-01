package PlayPanel.WestPanel;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.GraphicPanel;
import Interface.GameColor;
import Interface.GameFontB;
import Interface.GameSet;

class SpeedPanel extends GraphicPanel{
	JLabel speedLa=new JLabel(GameSet.getSpeed().toString());
	
	SpeedPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);	
		setBackground(null);
		setLayout(null);		
		setLocation(0,30);
		
		speedLa.setFont(new GameFontB(20));
		speedLa.setLocation(40,45);
		speedLa.setSize(120,50);
		speedLa.setForeground(GameColor.basic);
		add(speedLa);
		
		SpeedAni speedAni=new SpeedAni();
		speedAni.start();
		
	}
	
	class SpeedAni extends Thread{
		public void run(){
			
			NumberFormat numberFormat=new DecimalFormat("###.##");
			while(true){
				GameSet.speedUp(0.01);
			
				speedLa.setText(numberFormat.format(GameSet.getSpeed()));
				
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

