package WordPulsFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class WordPlusFrame extends JFrame{
	private KoreaInputPanel kinputPanel;
	private EnglishInputPanel einputPanel;
	private JButton plusbtn;
	private JLabel topla;
	private JTextArea koreanInput;
	private JTextArea englishInput;
	
	public WordPlusFrame(){
		setSize(400,400);
		setLayout(new BorderLayout());
		setVisible(true);
		setBackground(new Color(240,240,255));
		setTitle("Word Plus");
		setResizable(false);
		
		
		kinputPanel=new  KoreaInputPanel();
		einputPanel=new EnglishInputPanel();
		plusbtn=new JButton("PLUS");
		topla=new JLabel("Input Your Word");
		topla.setFont(new Font("고딕",Font.BOLD,25));
		add(topla,BorderLayout.NORTH);
		add(kinputPanel,BorderLayout.WEST);
		add(einputPanel,BorderLayout.CENTER);
		add(plusbtn,BorderLayout.SOUTH);
	}
	
	class KoreaInputPanel extends JPanel{
		KoreaInputPanel(){
			setBackground(Color.WHITE);
			setLayout(new BorderLayout());
			this.setPreferredSize(new Dimension(200,300));
			Border border= BorderFactory.createEtchedBorder();
			border=BorderFactory.createTitledBorder("Korean");
			setBorder(border);
			
			koreanInput=new JTextArea();
			
			add(koreanInput,BorderLayout.CENTER);
		}
	}
	
	class EnglishInputPanel extends JPanel{
		EnglishInputPanel(){
			setBackground(Color.WHITE);
			setLayout(new BorderLayout());
			Border border= BorderFactory.createEtchedBorder();
			border=BorderFactory.createTitledBorder("English");
			setBorder(border);
			
			englishInput=new JTextArea();
			add(englishInput,BorderLayout.CENTER);
		}
	}
}
