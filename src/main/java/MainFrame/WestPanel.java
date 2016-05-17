package MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import GameInterface.BasicInterface;
import Item.Item1;
import Item.Item2;
import Item.Item3;
import Item.Item4;

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
			double speedView;
			String s;
			NumberFormat numberFormat=new DecimalFormat("####.#");
			while(BasicInterface.play){
				BasicInterface.speed+=0.01;
				speedView=BasicInterface.speed*100;
				speedLa.setText(numberFormat.format(speedView));
				
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

class ItemPanel extends JPanel{
	ItemPanel(){
		Border itemBorder= BorderFactory.createEtchedBorder();
		itemBorder=BorderFactory.createTitledBorder("Item");
		setBorder(itemBorder);
		
		//Item 초기화
		Item1.init();
		Item2.init();
		Item3.init();
		Item4.init();
		
		setLayout(new GridLayout(4,1,0,0));
		setBackground(null);
		setPreferredSize(new Dimension(130,200));
		
		add(Item1.getBtn());
		add(Item2.getBtn());
		add(Item3.getBtn());
		add(Item4.getBtn());	
	}
}

public class WestPanel extends JPanel{
	
	WestPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));

		add(new SpeedPanel());
		add(new ItemPanel());
	}

}
