package TypeTrainer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
	
	MainFrame(){
		setTitle("Typing Trainer with English!");
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.WHITE);
	}
	
	public static void main(String[] args){
		MainFrame mf= new MainFrame();
		Container c = mf.getContentPane();
		
		EastPanel rp= new EastPanel();
		NorthPanel np= new NorthPanel();
		CenterPanel cp= new CenterPanel();
		SouthPanel sp= new SouthPanel();
		WestPanel wp= new WestPanel();
		
		c.add(rp,BorderLayout.EAST);
		c.add(np,BorderLayout.NORTH);
		c.add(cp,BorderLayout.CENTER);
		c.add(sp,BorderLayout.SOUTH);
		c.add(wp,BorderLayout.WEST);
	}
}
