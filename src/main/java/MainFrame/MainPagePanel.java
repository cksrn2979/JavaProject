package MainFrame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Graphics.GraphicButton;
import HelpFrame.HelpFrame;
import StartFrame.StartFrame;
import WordSetFrame.WordSetFrame;

public class MainPagePanel extends JPanel {
	public MainPagePanel() {
		setLayout(null);
		MakeButton();
	}

	void MakeButton() {
		String path = "images/MainFrame/MainPage/";

		GraphicButton btn[] = new GraphicButton[4];
		btn[0] = new GraphicButton(path, "Startbtn", 100, 35);
		btn[1] = new GraphicButton(path, "WordSetbtn", 100, 35);
		btn[2] = new GraphicButton(path, "Helpbtn", 100, 35);
		btn[3] = new GraphicButton(path, "Exitbtn", 100, 35);

		for (int i = 0; i < 4; i++) {
			btn[i].addActionListener(new MenuActionListener());
		}

		for (int i = 0; i < 4; i++) {
			btn[i].setLocation(330, 280 + (i * 40));
			add(btn[i]);
		}
	}

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame mf=(MainFrame)MainPagePanel.this.getTopLevelAncestor();
			
			GraphicButton btn = (GraphicButton) e.getSource();
			
			switch (btn.getFILENAME()) {
			case "Startbtn":
				mf.startFrame = new StartFrame(mf);
				break;
			case "WordSetbtn":
				new WordSetFrame();
				break;
			case "Helpbtn":new HelpFrame();
				break;
			case "Exitbtn":
				System.exit(0);
				break;
			}

		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("images/MainFrame/MainPage/Background.png");
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);

	}
}