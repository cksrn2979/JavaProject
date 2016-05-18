package MfWestPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import GameInterface.BasicInterface;
import MfWestPanel.SpeedPanel.SpeedAni;

class SpeedPanel extends JPanel{
	JLabel speedLa=new JLabel((BasicInterface.speed.toString()));
	
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
			
			NumberFormat numberFormat=new DecimalFormat("####.##");
			while(BasicInterface.play){
				BasicInterface.speed+=0.01;
			
				speedLa.setText(numberFormat.format(BasicInterface.speed));
				
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

