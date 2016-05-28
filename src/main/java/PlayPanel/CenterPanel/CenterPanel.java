package PlayPanel.CenterPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CenterPanel extends JPanel{
	public HeartGagePanel heartGagePanel;
	public FallWordPanel fallWordPanel;
	
	public CenterPanel(){
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500,420));
		
		heartGagePanel = new HeartGagePanel();
		fallWordPanel = new FallWordPanel();
		add(heartGagePanel,BorderLayout.NORTH);
		add(fallWordPanel,BorderLayout.CENTER);		
	}
	
		
}

