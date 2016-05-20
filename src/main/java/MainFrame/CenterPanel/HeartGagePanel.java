package MainFrame.CenterPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import MainFrame.Interface;
import ScoreFrame.ScoreFrame;

public class HeartGagePanel extends JPanel{
	public HeartGage heartGage;
	
	HeartGagePanel(){
		setBackground(null);
		add(new JLabel("HEART "));
		
		heartGage=new HeartGage();
		add(heartGage);
	}
	
	public class HeartGage extends JProgressBar{
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
		
		public void pain(){ //체력 감소
			value-=20;
			setValue(value);
			setString(value.toString()+"%");	
			
			if(value==0){ //체력이 없을 경우
				new ScoreFrame(); //scoreFrame 생성
				Interface.setPlay(false); //게임 멈춤
				return;
			}
		}
		
		public void fullgain(){
			setValue(max);
			setString(100+"%");
		}
	}
}
