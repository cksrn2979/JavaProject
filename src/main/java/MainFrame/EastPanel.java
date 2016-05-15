package MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import AllWordFrame.AllWordFrame;
import GameInterface.SuccessWord;

class InformationPanel extends JPanel{
	InformationPanel(){
		setBackground(null);
		setPreferredSize(new Dimension(0,60));
		
		Border infomationBorder= BorderFactory.createEtchedBorder();
		infomationBorder=BorderFactory.createTitledBorder("INFORMATION");
		setBorder(infomationBorder);
		
		Font font = new Font("나눔 고딕",Font.BOLD,13);
		JLabel la1=new JLabel("TRY - 20");
		JLabel la2=new JLabel("User : 서송이");
		la1.setFont(font);
		la2.setFont(font);
		add(la1);
		add(la2);		
	}
}

class SuccessWordPanel extends JPanel{
	
	SuccessWordPanel(){
		Border ListBorder= BorderFactory.createEtchedBorder();
		ListBorder=BorderFactory.createTitledBorder("Success Word");
		setBorder(ListBorder);
		setBackground(null);	
		
		JScrollPane scroll=new JScrollPane(SuccessWord.getTable());
		scroll.setPreferredSize(new Dimension(130,220));
		
		add(scroll);
	}	
}

class WordSetPanel extends JPanel{
	WordSetPanel(){
		
		setBackground(null);
		Border WordSetBorder= BorderFactory.createEtchedBorder();
		WordSetBorder=BorderFactory.createTitledBorder("WordSet");
		
		setBorder(WordSetBorder);
		JButton allWordBtn=new JButton("All Word");
		
		//allWordBtn Action 삽입
		allWordBtn.addActionListener(new AllWordActionListener());
		
		add(allWordBtn,BorderLayout.CENTER);
		add(new Button("+"),BorderLayout.EAST);
	}
	
	//AllWordBtn Frame생성 액션
	class AllWordActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new AllWordFrame();
		}
	}
}


public class EastPanel extends JPanel{
	EastPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		InformationPanel info=new InformationPanel();
		add(info);
		
		SuccessWordPanel successWord=new SuccessWordPanel();
		add(successWord);
		
		WordSetPanel wordSet=new WordSetPanel();
		add(wordSet);	

	}
}
