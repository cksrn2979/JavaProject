package TypeTrainer;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel{
	SouthPanel(){
		setBackground(Color.WHITE);
		
		JTextField input = new JTextField("",20);
		add(input);
		Button btn1= new Button("Input");
		btn1.setBackground(Color.WHITE);
		add(btn1);
		
		
	}
}
