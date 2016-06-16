package RankFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Graphics.GraphicButton;
import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class SubmitPanel extends JPanel{
	PlayPanel playPanel;
	GraphicButton homebtn;
	GraphicButton resumebtn;
	GraphicButton exitbtn;
	
	SubmitPanel(PlayPanel playPanel){
		this.playPanel=playPanel;
		setPreferredSize(new Dimension(600,80));
		this.setBackground(null);
		homebtn=new GraphicButton("images/RankFrame/","Homebtn",120,50);
		homebtn.addActionListener(new ButtonActionListener());
		
		resumebtn=new GraphicButton("images/RankFrame/","regameBtn",120,50);
		resumebtn.addActionListener(new ButtonActionListener());
		
		exitbtn=new GraphicButton("images/RankFrame/","exitbtn",120,50);
		exitbtn.addActionListener(new ButtonActionListener());
		
		add(homebtn);
		add(resumebtn);
		add(exitbtn);
	}
	
	class ButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			GraphicButton btn = (GraphicButton) e.getSource();

			switch (btn.getFILENAME()) {
			case "Homebtn":
				playPanel.play.goHome();
				break;
			case "regameBtn":
				playPanel.play.reGame();
				break;
			case "exitbtn":
				System.exit(0);
				playPanel.dictionary.writeWordUserDictionary();
				break;
			}
			
			RankFrame rankFrame=(RankFrame)SubmitPanel.this.getTopLevelAncestor();
			rankFrame.dispose();
		}
	}
}
