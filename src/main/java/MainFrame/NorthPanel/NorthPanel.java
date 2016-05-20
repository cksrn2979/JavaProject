package MainFrame.NorthPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MainFrame.Interface;

public class NorthPanel extends JPanel{
	private JLabel levella;
	private JLabel scorela;
	
	public NorthPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(0,40));
		
		Font font = new Font("고딕",Font.BOLD,20);
		levella = new JLabel("LEVEL : " + Interface.getLevel().toString());
		scorela = new JLabel("SCORE : " + Interface.getScore().toString());
		
		levella.setFont(font);
		scorela.setFont(font);
		add(levella);
		add(new JLabel("              "));
		add(scorela);
	}
	
	public void scorelaUP(){
		scorela.setText("SCORE : " + Interface.getScore().toString());
	}
}
