package RankFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;
import PlayPanel.PlayPanel;

public class RankFrame extends JFrame {
	public RankFrame(PlayPanel playPanel) {
		
		setSize(600, 540);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		getContentPane().setBackground(GlobalGraphic.character);		
		setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
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
