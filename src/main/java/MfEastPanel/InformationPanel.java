package MfEastPanel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import GameInterface.BasicInterface;

class InformationPanel extends JPanel{
	InformationPanel(){
		setBackground(null);
		setPreferredSize(new Dimension(0,60));
		
		Border infomationBorder= BorderFactory.createEtchedBorder();
		infomationBorder=BorderFactory.createTitledBorder("INFORMATION");
		setBorder(infomationBorder);
		
		Font font = new Font("나눔 고딕",Font.BOLD,13);
		JLabel la1=new JLabel("TRY - " + BasicInterface.gameTry.toString());
		JLabel la2=new JLabel("User : " + BasicInterface.user);
		la1.setFont(font);
		la2.setFont(font);
		add(la1);
		add(la2);		
	}
}