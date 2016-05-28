package StartFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.BtnGraphicAction;
import Graphics.BtnGraphicActionMainTain;
import Graphics.GraphicForm;
import Interface.GameColor;
import Interface.GameSet;
import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class StartFrame extends JFrame{
	public Window f=this;
	public ChoiceUserPanel choiceUserPa;
	public ChoiceLevelPanel choiceLevelPa;
	public SubmitPanel submitPa;
			
	public StartFrame(){
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		setVisible(true);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);

	
		setLayout(new BorderLayout());
		
		choiceUserPa=new ChoiceUserPanel();
		choiceLevelPa=new ChoiceLevelPanel();
		submitPa=new SubmitPanel();
		
		add(choiceUserPa,BorderLayout.NORTH);
		add(choiceLevelPa,BorderLayout.CENTER);
		add(submitPa,BorderLayout.SOUTH);
	}
	
}

	
