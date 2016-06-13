package PlayPanel.CenterPanel;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Graphics.GraphicPanel;

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
	
	public class TimerLabel extends JLabel{
		TimerLabel(ImageIcon imageIcon){
			super(imageIcon);
			setVisible(false);
		}
		
		public void action(int time){
			setVisible(true);
			Timer t = new Timer(false);
			TimerTask repairTask = new RepairTask();
			t.schedule(repairTask, time);
		}

		class RepairTask extends TimerTask {
			public void run() {
				setVisible(false);
			}
		}
	}
}
