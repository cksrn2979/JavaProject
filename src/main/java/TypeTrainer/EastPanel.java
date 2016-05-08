package TypeTrainer;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class WordListScroll extends JPanel{
	WordListScroll(){
		Border ListBorder= BorderFactory.createEtchedBorder();
		ListBorder=BorderFactory.createTitledBorder("Success Word");
		setBorder(ListBorder);
		setBackground(null);
		
		String word[] ={"사과 - apple","아빠- father","엄마 - mother","형 - brother",
				"사과 - apple","아빠- father","엄마 - mother","형 - brother",
				"사과 - apple","아빠- father","엄마 - mother","형 - brother",
				"사과 - apple","아빠- father","엄마 - mother","형 - brother",
				"사과 - apple","아빠- father","엄마 - mother","형 - brother",
				"사과 - apple","아빠- father","엄마 - mother","형 - brother"};
		
		JList wordList= new JList(word);
		JScrollPane p=new JScrollPane(wordList);
		p.setPreferredSize(new Dimension(130,200));
		
		add(p);
	}
	
}


public class EastPanel extends JPanel{
	EastPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel informPanel=new JPanel();
		informPanel.
		setBackground(null);
		Border infomationBorder= BorderFactory.createEtchedBorder();
		infomationBorder=BorderFactory.createTitledBorder("INFORMATION");
		informPanel.setBorder(infomationBorder);
		
		Font font = new Font("나눔 고딕",Font.BOLD,13);
		JLabel la1=new JLabel("TRY - 20");
		JLabel la2=new JLabel("User : 서송이");
		la1.setFont(font);
		la2.setFont(font);
		informPanel.add(la1);
		informPanel.add(la2);
		
		add(informPanel);

		
		WordListScroll w=new WordListScroll();
		add(w);
		
		Border WordSettingBorder= BorderFactory.createEtchedBorder();
		WordSettingBorder=BorderFactory.createTitledBorder("WordSetting");
		JPanel j=new JPanel();
		j.setBorder(WordSettingBorder);
		j.add(new Button("all View Word"),BorderLayout.CENTER);
		j.add(new Button("+"),BorderLayout.EAST);
		j.setBackground(null);
		add(j);

	


	}
}
