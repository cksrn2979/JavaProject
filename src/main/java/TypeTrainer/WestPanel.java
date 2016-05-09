package TypeTrainer;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class TypingSpeed extends JPanel{
	TypingSpeed(){
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

class ItemList extends JPanel{
	ItemList(){
		Border itemBorder= BorderFactory.createEtchedBorder();
		itemBorder=BorderFactory.createTitledBorder("Item");
		setBorder(itemBorder);
		
		setLayout(new GridLayout(4,1,0,0));
		setBackground(null);
		setPreferredSize(new Dimension(130,200));
		
		Button item1 =new Button("item1");
		Button item2 =new Button("item2");
		Button item3 =new Button("item3");
		Button item4 =new Button("item4");
		
		item1.setBackground(Color.WHITE);
		item2.setBackground(Color.DARK_GRAY);
		item3.setBackground(Color.DARK_GRAY);
		item4.setBackground(Color.WHITE
				);
		
		add(item1);
		add(item2);
		add(item3);
		add(item4);	
	}
}

public class WestPanel extends JPanel{
	
	WestPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));

		add(new TypingSpeed());
		add(new ItemList());
	}

}
