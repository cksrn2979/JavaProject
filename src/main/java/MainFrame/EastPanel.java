package MainFrame;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

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
		
		String header[] ={"Korea","English"};
		String contents[][]={{"사과","apple"},{"사과","apple"},{"사과","apple"},
				{"사과","apple"},{"사과","apple"},{"사과","apple"},{"사과","apple"},
				{"사과","apple"},{"사과","apple"},{"사과","apple"},{"사과","apple"},
				{"사과","apple"},{"사과","apple"},{"사과","apple"},{"사과","apple"},
				{"사과","apple"},{"사과","apple"},{"사과","apple"},{"사과","apple"},
				{"사과","apple"},{"사과","apple"},{"사과","apple"},{"사과","apple"},
				{"사과","apple"}
		};
		JTable wordList= new JTable(contents,header);
		JScrollPane scroll=new JScrollPane(wordList);
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
		add(new Button("All Word"),BorderLayout.CENTER);
		add(new Button("+"),BorderLayout.EAST);
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
