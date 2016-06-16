package PauseFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;
import Graphics.GraphicButton;
import Graphics.MainPoint;
import MainFrame.MainFrame;

public class PauseFrame extends JFrame {
	private MainFrame mf;
	GraphicButton homebtn;
	GraphicButton resumebtn;
	GraphicButton exitbtn;

	public PauseFrame(MainFrame mf) {
		this.mf = mf;
		setLayout(new FlowLayout());
		setSize(150, 180);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// 크기 고정
		setUndecorated(true);
		getContentPane().setBackground(GlobalGraphic.character);
		setVisible(true);
		this.setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 50, 50));
		setLocation(MainPoint.x-(this.getWidth()/2), MainPoint.y-(this.getHeight()/2));

		homebtn = new GraphicButton("images/PauseFrame/", "Homebtn", 120, 50);
		homebtn.addActionListener(new ButtonActionListener());

		resumebtn = new GraphicButton("images/PauseFrame/", "resumebtn", 120, 50);
		resumebtn.addActionListener(new ButtonActionListener());

		exitbtn = new GraphicButton("images/PauseFrame/", "exitbtn", 120, 50);
		exitbtn.addActionListener(new ButtonActionListener());

		add(homebtn);
		add(resumebtn);
		add(exitbtn);
	}

	class ButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			GraphicButton btn = (GraphicButton) e.getSource();

			switch (btn.getFILENAME()) {
			case "Homebtn":
				mf.playPanel.play.goHome();
				break;
			case "resumebtn":
				mf.playPanel.play.resumeGame();
				break;
			case "exitbtn":
				System.exit(0);
				mf.playPanel.dictionary.writeWordUserDictionary();
				break;
			}
			
			PauseFrame.this.dispose();
		}

	}

}
