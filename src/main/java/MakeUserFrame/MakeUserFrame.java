package MakeUserFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Graphics.GlobalGraphic;
import Graphics.GraphicButton;
import Graphics.GraphicRadioButton;
import MainFrame.MainFrame;
import WordSetFrame.SubmitButtonPanel;

public class MakeUserFrame extends JFrame{
	ChoiceCharacterPanel choiceChracterPanel;
	UserInputPanel userInputPanel;
	SubmitPanel submitPanel;

	public MakeUserFrame(){
		setSize(400,320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		this.getContentPane().setBackground(GlobalGraphic.basic2);
		setVisible(true);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);

		this.setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		setLayout(null);
		
		choiceChracterPanel = new ChoiceCharacterPanel();
		choiceChracterPanel.setLocation(0, 50);
		choiceChracterPanel.setSize(400,150);
		
		userInputPanel = new UserInputPanel();
		userInputPanel.setLocation(0,200);
		userInputPanel.setSize(400,50);
		
		submitPanel = new SubmitPanel();
		submitPanel.setLocation(0,250);
		submitPanel.setSize(400,50);		
		
		add(choiceChracterPanel);
		add(userInputPanel);
		add(submitPanel);
	}		
}
