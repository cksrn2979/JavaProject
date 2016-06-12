package StartFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.GlobalGraphic;

public class StartFrame extends JFrame{
	public Window f=this;
	public UserListPanel userListPa;
	public LevelListPanel levelListPa;
	public SubmitPanel submitPa;
	public StartFrame(){
		setSize(400,250);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		setVisible(true);
		setContentPane(new StartPanel());
		getContentPane().setBackground(GlobalGraphic.basic2);
		this.setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
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
			levelListPa.setLocation(0,110);
			
			
			submitPa=new SubmitPanel();
			submitPa.setSize(400,50);
			submitPa.setLocation(50,180);
			
			add(levelListPa,BorderLayout.CENTER);
			add(submitPa,BorderLayout.SOUTH);
		}
	
	}
	
}

	
