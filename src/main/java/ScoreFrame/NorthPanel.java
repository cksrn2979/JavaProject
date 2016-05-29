package ScoreFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interface.GameColor;
import Interface.GameSet;

public class NorthPanel extends JPanel{
	NorthPanel(){
		setBackground(GameColor.basic);
		setPreferredSize(new Dimension(800,60));
		setLayout(null);
	}	
	
	public void paintComponent(Graphics g) {
		String path="C:/Users/Song/git/JavaProject/images/ScoreFrame/NorthPanel/";
		ImageIcon imgIcon=new ImageIcon(path+"background"+".png");
		g.drawImage(imgIcon.getImage(), 0, 0, null);	
		setOpaque(false);
		super.paintComponent(g);
	}
}
