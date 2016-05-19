package MainFrame.CenterPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import MainFrame.MainFrame;
import ScoreFrame.ScoreFrame;

class HeartGagePanel extends JPanel{
	static HeartGage heartGage=new HeartGage();
	
	HeartGagePanel(){
		setBackground(null);
		add(new JLabel("HEART "));
		add(heartGage);
	}
	
	static class HeartGage extends JProgressBar{
		int max=100;
		int min=0;
		Integer value=100;
		
		HeartGage(){
			setMinimum(min);
			setMaximum(max);
			setForeground(new Color(255,100,100));
			setStringPainted(true);
			setString(value.toString()+"%");
			setValue(value);
		}
		
		public void pain(){
			value-=20;
			setValue(value);
			setString(value.toString()+"%");	
			
			if(value==0){
				new ScoreFrame();
				MainFrame.setPlay(false);
				return;
			}
		}
	}
}
