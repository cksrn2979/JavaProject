package TypeTrainer;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class CenterPanel extends JPanel{
	
	CenterPanel(){
		setBackground(Color.WHITE);
		setLayout(null);
		Border CenterBorder= BorderFactory.createEtchedBorder();
		setBorder(CenterBorder);
		
		Font font = new Font("굴림",Font.BOLD,15);
		Font font2 = new Font("궁서",Font.ITALIC,18);
		JLabel la1=new JLabel("우주");
		JLabel la2=new JLabel("지구");
		JLabel la3=new JLabel("딸기");
		JLabel la4=new JLabel("수박");
		JLabel la5=new JLabel("Computer");
		
		la1.setFont(font);
		la1.setSize(40,40);
		la1.setLocation(40,40);
		
		la2.setFont(font);
		la2.setSize(40,40);
		la2.setLocation(100,100);
		
		la3.setFont(font);
		la3.setSize(40,40);
		la3.setLocation(200,250);
		
		la4.setFont(font);
		la4.setSize(40,40);
		la4.setLocation(400,100);
		
		la5.setFont(font2);
		la5.setSize(100,100);
		la5.setLocation(300,200);
		
		add(la1);
		add(la2);
		add(la3);
		add(la4);
		add(la5);
	}


}
