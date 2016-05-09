package TypeTrainer;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class Information extends JPanel{
	Information(){
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

class SuccessWord extends JPanel{
	SuccessWord(){
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

class WordSet extends JPanel{
	WordSet(){
		
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
			
		Information info=new Information();
		add(info);
		
		SuccessWord successWord=new SuccessWord();
		add(successWord);
		
		WordSet wordSet=new WordSet();
		add(wordSet);	

	}
}
