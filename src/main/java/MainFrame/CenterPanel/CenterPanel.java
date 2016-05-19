package MainFrame.CenterPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CenterPanel extends JPanel{
	public HeartGagePanel heartGagePanel;
	public FallWordPanel fallWordPanel;
	
	public CenterPanel(){
		
		setBackground(Color.WHITE);
		Border CenterBorder= BorderFactory.createEtchedBorder();
		setBorder(CenterBorder);
		setLayout(new BorderLayout());
		
		heartGagePanel = new HeartGagePanel();
		fallWordPanel = new FallWordPanel();
		add(heartGagePanel,BorderLayout.NORTH);
		add(fallWordPanel,BorderLayout.CENTER);
		
	}
}