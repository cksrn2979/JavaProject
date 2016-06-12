package ScoreFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class ScoreFrame extends JFrame {
	public static ScoreFrame sf;
	public static FileIO fIO;
	public PlayPanel p;

	public ScoreFrame() {
		this.p = MainFrame.mf.playPanel;

		setSize(600, 400);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		setBackground(Graphics.GlobalGraphic.basic);		
		setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
	
		fIO = new FileIO();

		NorthPanel north = new NorthPanel("images/ScoreFrame/", "NorthPanel", 600, 40);
		CenterPanel center = new CenterPanel(p);

		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);

	}
}
