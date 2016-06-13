package PlayPanel.CenterPanel;

import java.util.Vector;

import javax.swing.ImageIcon;

import Graphics.GraphicPanel;
import Graphics.TimerLabel;

public class CenterPanel extends GraphicPanel{
	public HeartGagePanel heartGagePa;
	public TimerLabel levelUpLabel;
	public TimerLabel itemLabel;

	private Vector<FallWordLabel> fallWordLabelArray;	
	
	public CenterPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setLayout(null);
				
		fallWordLabelArray= new Vector<FallWordLabel>();
	
		itemLabel=new TimerLabel(new ImageIcon(path+"Item.gif"));
		itemLabel.setSize(200,200);
		itemLabel.setLocation(150,100);
		add(itemLabel);
		
		levelUpLabel=new TimerLabel(new ImageIcon(path+"levelUp.gif"));
		levelUpLabel.setSize(200,200);
		levelUpLabel.setLocation(150,100);
		add(levelUpLabel);
		
		heartGagePa = new HeartGagePanel(path,"HeartGageGra",200,30);
		heartGagePa.setLocation(150,10);
		add(heartGagePa);
			
		
	}
	
	public Vector<FallWordLabel> getLabelArray(){return fallWordLabelArray;}
	
	public void clearLabel() {
		for (int index = 0; index < fallWordLabelArray.size(); index++) {
			fallWordLabelArray.get(index).setVisible(false);
			fallWordLabelArray.get(index).setValid(false);
		}
		fallWordLabelArray.removeAllElements();
	}
}
