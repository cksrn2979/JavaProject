package MainFrame.EastPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import MainFrame.Interface;

class InformationPanel extends JPanel{
	InformationPanel(){
		setBackground(null);
		setPreferredSize(new Dimension(0,60));
		setLayout(new GridLayout(2,1,0,0));

		
		Border infomationBorder= BorderFactory.createEtchedBorder();
		infomationBorder=BorderFactory.createTitledBorder("INFORMATION");
		setBorder(infomationBorder);
		
		Font font = new Font("고딕",Font.BOLD,13);
		JLabel la1=new JLabel("TRY - " + Interface.getGameTry().toString());
		JLabel la2=new JLabel("User : " + Interface.getUser());
		la1.setFont(font);
		la2.setFont(font);
		add(la1);
		add(la2);		
	}
}