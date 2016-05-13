package TypeTrainerScore;
import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
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
