package WordSetFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.GraphicButton;

public class SubmitButtonPanel extends JPanel{
	GraphicButton wordPlusbtn;
	GraphicButton successResetbtn;
	
	SubmitButtonPanel(){		
		setBackground(null);
		makeBtn();
	}
	
	void makeBtn(){
		
		wordPlusbtn=new GraphicButton("images/WordSetFrame/","SubmitBtn",90,35);
		wordPlusbtn.addActionListener(new SubmitAction());
		
		successResetbtn=new GraphicButton("images/WordSetFrame/","ConcealBtn",90,35);
		successResetbtn.addActionListener(new SubmitAction());
		
		add(wordPlusbtn);
		add(successResetbtn);
	}
	
	class SubmitAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GraphicButton btn=(GraphicButton)e.getSource();
			if(btn.getFILENAME()=="SubmitBtn");
			else if (btn.getFILENAME()=="ConcealBtn");
			
			JFrame topFrame=(JFrame)(SubmitButtonPanel.this.getTopLevelAncestor());
			topFrame.dispose();
		}
	}
}
