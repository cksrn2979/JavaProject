package MainFrame.WestPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import MainFrame.Interface;
import MainFrame.MainFrame;

class SpeedPanel extends JPanel{
	JLabel speedLa=new JLabel(Interface.getSpeed().toString());
	
	SpeedPanel(){
		Border typingSpeedBorder= BorderFactory.createEtchedBorder();
		typingSpeedBorder=BorderFactory.createTitledBorder("SPEED");
		setBorder(typingSpeedBorder);
		
		setPreferredSize(new Dimension(130,100));
		setBackground(null);
		
	
		speedLa.setFont(new Font("나눔 고딕",Font.BOLD,40));		
		add(speedLa);
		
		SpeedAni speedAni=new SpeedAni();
		speedAni.start();
		
	}
	
	class SpeedAni extends Thread{
		public void run(){
			
			NumberFormat numberFormat=new DecimalFormat("###.##");
			while(Interface.getPlay()){
				Interface.speedUp(0.01);
			
				speedLa.setText(numberFormat.format(Interface.getSpeed()));
				
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

