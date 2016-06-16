package RankFrame;

import java.awt.BorderLayout;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;
import Graphics.MainPoint;
import PlayPanel.PlayPanel;

public class RankFrame extends JFrame {
	public RankFrame(PlayPanel playPanel) {
		
		setSize(600, 540);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		getContentPane().setBackground(GlobalGraphic.character);		
		setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		
		setLocation(MainPoint.x-(this.getWidth()/2), MainPoint.y-(this.getHeight()/2));
		
		NorthPanel northPanel = new NorthPanel("images/RankFrame/", "NorthPanel", 600, 100);
		CenterPanel centerPanel = new CenterPanel(playPanel);
		SubmitPanel southPanel =new SubmitPanel(playPanel);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);		
		add(southPanel, BorderLayout.SOUTH);
		
		revalidate();
		repaint();
	}
}
