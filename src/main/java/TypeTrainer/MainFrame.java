package TypeTrainer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
	MainFrame(){
		setTitle("Type Trainer with English!");
		setSize(1000,1000);
		setVisible(true);
		setBackground(Color.WHITE);
	}
	public static void main(String[] args){
		MainFrame mf= new MainFrame();
		Container c = mf.getContentPane();
		
		c.add(new RightPanel(),BorderLayout.EAST);
		c.add(new NorthPanel(),BorderLayout.NORTH);
	}
}
