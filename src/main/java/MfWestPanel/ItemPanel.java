package MfWestPanel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ItemPanel extends JPanel{
	public static Item item[]=new Item[4];
	public static JButton itemBtn[]=new JButton[4];
	
	ItemPanel(){
		Border itemBorder= BorderFactory.createEtchedBorder();
		itemBorder=BorderFactory.createTitledBorder("Item");
		setBorder(itemBorder);
		
		setLayout(new GridLayout(4,1,0,0));
		setBackground(null);
		setPreferredSize(new Dimension(130,200));
		
		item[0]=new Item1();
		item[1]=new Item2();
		item[2]=new Item3();
		item[3]=new Item4();
		
		itemBtn[0]=new JButton("모두 지우기");
		itemBtn[1]=new JButton("천천히");
		itemBtn[2]=new JButton("느리게");
		itemBtn[3]=new JButton("미정");
		
		for(int i=0; i<4; i++){
			itemBtn[i].setEnabled(false);
			add(itemBtn[i]);
		}			
	}
	
	
}