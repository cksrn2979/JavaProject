package ScoreFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Interface.GameSet;
import StartFrame.ChoiceLevelPanel;
import StartFrame.ChoiceUserPanel;
import StartFrame.SubmitPanel;
import ScoreFrame.FileIO.*;
public class ScorePanel extends JFrame{
	
		
		ScorePanel(){
			setSize(800,550);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);//크기 고정
			setUndecorated(true);
			setVisible(true);
			
			//com.sun.awt.AWTutilities.setWindowShape(this,new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),20,20));
			
			Dimension frameSize = getSize();
			Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
			setLocation((windowSize.width - frameSize.width) / 2,
					(windowSize.height - frameSize.height) / 2);
			
			NorthPanel north=new NorthPanel();
			SouthPanel south=new SouthPanel();
			CenterPanel center=new CenterPanel();
			add(center,BorderLayout.CENTER);
			add(north,BorderLayout.NORTH);
			add(south,BorderLayout.SOUTH);
			
		}
		
		
		public static void main(String[] args){
			new ScorePanel();
			new FileIO();
		
		}
}

