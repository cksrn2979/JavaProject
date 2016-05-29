package PlayPanel.WestPanel;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.GraphicForm;
import Interface.GameColor;
import Interface.GameFontB;
import Interface.GameSet;

class SpeedPanel extends JPanel{
	JLabel speedLa=new JLabel(GameSet.getSpeed().toString());
	
	SpeedPanel(){
				
		setPreferredSize(new Dimension(100,150));
		setBackground(null);
		setLayout(null);
		
		
		String path="images/MainFrame/"+GameSet.getCharacter() +"/PlayPanel/WestPanel/SpeedPanel/SpeedGra";
		SpeedGraphic speedGra=new SpeedGraphic(path,"speedGra",100,100);
		speedGra.setLocation(0,30);
		add(speedGra);
		
		SpeedAni speedAni=new SpeedAni();
		speedAni.start();
		
	}
	
	class SpeedGraphic extends GraphicForm{
		public SpeedGraphic(String path, String btnID, int width, int height) {
			super(path, btnID, width, height);			
			setLayout(null);
			speedLa.setFont(new GameFontB(20));
			speedLa.setLocation(25,20);
			speedLa.setSize(120,50);
			speedLa.setForeground(GameColor.basic);
			add(speedLa);
		}		
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

