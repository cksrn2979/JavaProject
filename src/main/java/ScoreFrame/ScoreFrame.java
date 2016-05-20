package ScoreFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ScoreFrame extends JFrame {
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("파일");
	JMenu helpMenu=new JMenu("Help");
	
	public ScoreFrame(){
		setTitle("Score Menu");
		setSize(600,450);
		setVisible(true);
		setBackground(Color.WHITE);
		
		add(new NorthPanel(),BorderLayout.NORTH);
		add(new CenterPanel(),BorderLayout.CENTER);
		add(new SouthPanel(),BorderLayout.SOUTH);
	}
}
