package ScoreFrame;
import javax.swing.*;
import java.awt.*;

class SouthPanel extends JPanel {
	SouthPanel(){
		setBackground(Color.WHITE);
		
		Button yesBtn=new Button("yes");
		Button noBtn=new Button("no");
		JLabel restart=new JLabel("restart? : ");
		
		add(restart);
		add(yesBtn);
		add(noBtn);
		
		}
}
