package WordSetFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Graphics.GraphicButton;

public class SetButtonPanel extends JPanel{
	GraphicButton wordPlusbtn;
	GraphicButton successResetbtn;
	
	SetButtonPanel(){		
		setBackground(null);
		makeBtn();
	}
	
	void makeBtn(){
		
		wordPlusbtn=new GraphicButton("images/WordSetFrame/","wordPlusBtn",100,40);
		successResetbtn=new GraphicButton("images/WordSetFrame/","SuccessResetBtn",100,40);
		
		add(wordPlusbtn);
		add(successResetbtn);
	}
	

}
