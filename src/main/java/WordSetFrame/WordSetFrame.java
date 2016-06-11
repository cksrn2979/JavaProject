package WordSetFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;

//AllWordList 프레임
public class WordSetFrame extends JFrame{
	WordListPanel wordListPanel;
	UserListPanel userListPanel;
	SetButtonPanel setButtonPanel;
	SubmitButtonPanel submitButtonPanel;
	
	public WordSetFrame(){
		setLayout(null);
		setSize(600,350);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		getContentPane().setBackground(GlobalGraphic.basic);
		setVisible(true);	
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);;
		
		userListPanel=new UserListPanel("images/WordSetFrame/","UserListPanel",250,40);
		userListPanel.setLocation(300,40);		
		
		wordListPanel=new WordListPanel();
		wordListPanel.setLocation(20,20);
		wordListPanel.setSize(250,310);
		
		
		
		SetButtonPanel setButtonPanel = new SetButtonPanel();
		setButtonPanel.setLocation(300, 120);
		setButtonPanel.setSize(250, 150);
		
		submitButtonPanel = new SubmitButtonPanel();
		submitButtonPanel.setLocation(300, 270);
		submitButtonPanel.setSize(250, 100);

		add(wordListPanel);		
		add(userListPanel);
		add(setButtonPanel);
		add(submitButtonPanel);		
		
	}
	
}
