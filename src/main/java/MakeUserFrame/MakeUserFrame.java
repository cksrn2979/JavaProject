package MakeUserFrame;

import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import Graphics.GlobalGraphic;
import Graphics.MainPoint;
import StartFrame.StartFrame;

public class MakeUserFrame extends JFrame {
	StartFrame startFrame;
	ChoiceCharacterPanel choiceChracterPanel;
	UserInputPanel userInputPanel;
	SubmitPanel submitPanel;

	public MakeUserFrame(StartFrame startFrame) {
		this.startFrame=startFrame;
		
		setSize(400, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// 크기 고정
		setUndecorated(true);
		this.getContentPane().setBackground(GlobalGraphic.basic2);
		setVisible(true);

		setLocation(MainPoint.x-(this.getWidth()/2), MainPoint.y-(this.getHeight()/2));

		this.setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 100, 100));
		setLayout(null);

		choiceChracterPanel = new ChoiceCharacterPanel();
		choiceChracterPanel.setLocation(0, 50);
		choiceChracterPanel.setSize(400, 150);

		userInputPanel = new UserInputPanel();
		userInputPanel.setLocation(0, 200);
		userInputPanel.setSize(400, 50);

		submitPanel = new SubmitPanel();
		submitPanel.setLocation(0, 250);
		submitPanel.setSize(400, 50);

		add(choiceChracterPanel);
		add(userInputPanel);
		add(submitPanel);
	}
}
