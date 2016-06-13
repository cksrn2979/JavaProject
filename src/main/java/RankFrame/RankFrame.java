package RankFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class RankFrame extends JFrame {
	public RankFrame(String user, String chracter, Integer score, Integer level) {
		System.out.println(user + chracter);
		setSize(600, 460);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		getContentPane().setBackground(Graphics.GlobalGraphic.basic);		
		setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
		NorthPanel north = new NorthPanel("images/ScoreFrame/", "NorthPanel", 600, 100);
		CenterPanel center = new CenterPanel(user, chracter, score, level);


		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		
		revalidate();
		repaint();
	}
	
	public static void main(String[] args){
		new RankFrame("chagnoo","MUZI",10,0);
	}
}
