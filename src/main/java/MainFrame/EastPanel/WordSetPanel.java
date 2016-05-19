package MainFrame.EastPanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import AllWordFrame.AllWordFrame;
import MainFrame.MainFrame;

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
			MainFrame.setPlay(false);
		}
	}
}