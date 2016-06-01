package StartFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Interface.GameColor;

public class StartFrame extends JFrame{
	public Window f=this;
	public UserListPanel userListPa;
	public LevelListPanel levelListPa;
	public SubmitPanel submitPa;
			
	public StartFrame(){
		setSize(400,300);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		setVisible(true);
		setContentPane(new StartPanel());
		getContentPane().setBackground(GameColor.basic);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);	
	
	}
	
	class StartPanel extends JPanel{
		StartPanel(){
			setLayout(null);			
			String path="images/StartFrame/";
			userListPa=new UserListPanel(path,"UserListPa",300,40);
			userListPa.setLocation(40,50);
			add(userListPa);
			
			levelListPa=new LevelListPanel();
			levelListPa.setSize(400,70);
			levelListPa.setLocation(0,120);
			
			
			submitPa=new SubmitPanel();
			submitPa.setSize(400,50);
			submitPa.setLocation(50,220);
			
			add(levelListPa,BorderLayout.CENTER);
			add(submitPa,BorderLayout.SOUTH);
		}
	
	}
	
}

	
