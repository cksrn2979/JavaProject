package WordSetFrame;

import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;
import Graphics.MainPoint;

//AllWordList 프레임
public class WordSetFrame extends JFrame{
	public WordListPanel wordListPanel;
	UserListPanel userListPanel;
	SetButtonPanel setButtonPanel;
	SubmitButtonPanel submitButtonPanel;
	
	public WordSetFrame(){
		setLayout(null);
		setSize(600,350);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		getContentPane().setBackground(GlobalGraphic.basic2);
		setVisible(true);	
		setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		setLocation(MainPoint.x-(this.getWidth()/2), MainPoint.y-(this.getHeight()/2));
		
		userListPanel = new UserListPanel("images/WordSetFrame/", "UserListPanel", 250, 40);
		userListPanel.setLocation(300, 40);

		wordListPanel = new WordListPanel();
		wordListPanel.setLocation(30, 20);
		wordListPanel.setSize(250, 305);

		SetButtonPanel setButtonPanel = new SetButtonPanel();
		setButtonPanel.setLocation(300, 120);
		setButtonPanel.setSize(250, 150);

		submitButtonPanel = new SubmitButtonPanel();
		submitButtonPanel.setLocation(300, 270);
		submitButtonPanel.setSize(300, 100);

		add(wordListPanel);
		add(userListPanel);
		add(setButtonPanel);
		add(submitButtonPanel);
		
	}
	
}
