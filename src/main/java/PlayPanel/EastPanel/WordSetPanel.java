package PlayPanel.EastPanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import AllWordFrame.AllWordFrame;
import Interface.GameSet;
import StartFrame.StartFrame;
import WordPlusFrame.WordPlusFrame;

class WordSetPanel extends JPanel{
	private JButton allWordbtn;
	private JButton plusbtn;
	WordSetPanel(){
		
		setBackground(null);
		Border WordSetBorder= BorderFactory.createEtchedBorder();
		WordSetBorder=BorderFactory.createTitledBorder("WordSet");
		
		setBorder(WordSetBorder);
		allWordbtn=new JButton("All Word");
		plusbtn=new JButton("+");
		
		
		//allWordBtn Action 삽입
		allWordbtn.addActionListener(new AllWordActionListener());
		plusbtn.addActionListener(new AllWordActionListener());
		
		add(allWordbtn,BorderLayout.CENTER);
		add(plusbtn,BorderLayout.EAST);
	}
	
	//AllWordBtn Frame생성 액션
	class AllWordActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton btn=(JButton)e.getSource();
			if(btn.getText().equals("All Word"))
				new AllWordFrame();
					
			else if(btn.getText().equals("+"))
				new WordPlusFrame();
			GameSet.setStop();
		}
	}
}