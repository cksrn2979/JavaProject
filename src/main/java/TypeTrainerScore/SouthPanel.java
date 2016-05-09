package TypeTrainerScore;
import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
SouthPanel(){
	setBackground(Color.WHITE);
	
	Button yes=new Button("yes");
	Button no=new Button("no");
	JLabel restart=new JLabel("restart? : ");
	
	add(restart);
	add(yes);
	add(no);
	
	}
}
