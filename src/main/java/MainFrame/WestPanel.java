package MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Item.Item1;
import Item.Item2;
import Item.Item3;
import Item.Item4;

class SpeedPanel extends JPanel{
	SpeedPanel(){
		Border typingSpeedBorder= BorderFactory.createEtchedBorder();
		typingSpeedBorder=BorderFactory.createTitledBorder("SPEED");
		setBorder(typingSpeedBorder);
		
		setPreferredSize(new Dimension(130,100));
		setBackground(null);
		
		JLabel speed=new JLabel("0.44");
		speed.setFont(new Font("나눔 고딕",Font.BOLD,40));		
		add(speed);
	}
}

class ItemPanel extends JPanel{
	ItemPanel(){
		Border itemBorder= BorderFactory.createEtchedBorder();
		itemBorder=BorderFactory.createTitledBorder("Item");
		setBorder(itemBorder);
		
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
