package ScoreFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class ScorePanel extends JFrame{
		public static ScorePanel sp;
		public static FileIO fIO;
		
		ScorePanel(){
			setSize(800,550);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
			setUndecorated(true);
			setVisible(true);
			
			Dimension frameSize = getSize();
			Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
			setLocation((windowSize.width - frameSize.width) / 2,
					(windowSize.height - frameSize.height) / 2);
			
			fIO=new FileIO();
			
			String npPath="images/ScoreFrame/NorthPanel/";
			NorthPanel north=new NorthPanel(npPath,"backgorund",800,60);
			CenterPanel center=new CenterPanel();
			
			add(center,BorderLayout.CENTER);
			add(north,BorderLayout.NORTH);
		
		}
		
		public static void main(String[] args){
			sp=new ScorePanel();
			 
			System.out.println("Main에서 함수 호출 테스트  : "+fIO.getScore("rion"));
			
		}
}

