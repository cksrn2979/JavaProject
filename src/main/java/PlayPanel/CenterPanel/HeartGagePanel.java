package PlayPanel.CenterPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Graphics.GraphicForm;
import Interface.GameFontB;
import Interface.GameSet;
import ScoreFrame.ScoreFrame;

public class HeartGagePanel extends JPanel{
	public HeartGageGraphic heartGageGra;
	
	HeartGagePanel(){
		setPreferredSize(new Dimension(500,50));
		setLayout(null);
		String path="images/MainFrame/"+GameSet.getCharacter()+"/PlayPanel/CenterPanel/HeartGagePanel/HeartGageGra";
		heartGageGra=new HeartGageGraphic(path, "HeartGageGra", 200, 30);
		heartGageGra.setLocation(140,15);
		add(heartGageGra);
	}
	
	public void paintComponent(Graphics g) {
		ImageIcon background = new ImageIcon("images/MainFrame/"+GameSet.getCharacter()+"/PlayPanel/CenterPanel/HeartGagePanel/Background.png");	
		g.drawImage(background.getImage(), 0, 0, null);	
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public class HeartGageGraphic extends GraphicForm{
		public HeartGage heartgage=new HeartGage();
		
		public HeartGageGraphic(String path, String btnID, int width, int height) {
			super(path, btnID, width, height);		
			heartgage=new HeartGage();
			heartgage.setFont(new GameFontB(10));
			heartgage.setPreferredSize(new Dimension(130,15));
			add(heartgage);
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
				setPreferredSize(new Dimension(200,20));
				setValue(value);
			
			}
			
			public void pain(){ //체력 감소
				value-=20;
				setValue(value);
				setString(value.toString()+"%");	
				
				if(value==0){ //체력이 없을 경우
					new ScoreFrame(); //scoreFrame 생성
					GameSet.setStop(); //게임 멈춤
					return;
				}
			}
			
			public void fullgain(){
				setValue(max);
				setString(100+"%");
			}
		}
	}
	
	
}
