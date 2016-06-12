package ScoreFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;
import PlayPanel.PlayPanel;
public class ScoreFrame extends JFrame{
		public static ScoreFrame sf;
		public static FileIO fIO;
		public PlayPanel p;
		
		public ScoreFrame(PlayPanel p){
			
			setSize(800,550);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
			setVisible(true);
			setBackground(Graphics.GlobalGraphic.basic);
			
			Dimension frameSize = getSize();
			Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
			setLocation((windowSize.width - frameSize.width) / 2,
					(windowSize.height - frameSize.height) / 2);
			
			this.p=p;
			fIO=new FileIO(p);
			
			
			String npPath="images/ScoreFrame/NorthPanel/";
			NorthPanel north=new NorthPanel(npPath,"Background",800,60);
			CenterPanel center=new CenterPanel(p);
			
			add(center,BorderLayout.CENTER);
			add(north,BorderLayout.NORTH);
		
		}
}

