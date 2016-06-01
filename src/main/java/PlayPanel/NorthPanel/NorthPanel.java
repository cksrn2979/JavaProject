package PlayPanel.NorthPanel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.GraphicPanel;
import Interface.GameColor;
import Interface.GameFontB;
import Interface.GameSet;

public class NorthPanel extends GraphicPanel{
	private JLabel levella;
	private JLabel scorela;
	private LevelGraphic levelPa;
	private ScoreGraphic scorePa;
	
	public NorthPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setLayout(null);
		
		String graPath=GameSet.getPath()+"NorthPanel/";
		levelPa=new LevelGraphic(graPath,"levelGra",130,50);
		scorePa=new ScoreGraphic(graPath,"scoreGra",130,50);
		
		levelPa.setLocation(250,0);
		scorePa.setLocation(400,0);
		add(levelPa);
		add(scorePa);		
	}
	
	
	class LevelGraphic extends GraphicPanel{
		public LevelGraphic(String path, String FILENAME, int width, int height) {
			super(path, FILENAME, width, height);
			setLayout(null);
			levella = new JLabel(GameSet.getLevel().toString());
			levella.setFont(new GameFontB(17));
			levella.setSize(100,40);
			levella.setLocation(90,8);
			add(levella);
		}
		
	}
	
	class ScoreGraphic extends GraphicPanel{
		public ScoreGraphic(String path, String FILENAME, int width, int height) {
			super(path, FILENAME, width, height);
			setLayout(null);
			scorela = new JLabel(GameSet.getScore().toString());
			scorela.setFont(new GameFontB(17));
			scorela.setSize(100,40);
			scorela.setLocation(90,8);
			add(scorela);
		}
		
	}
	
	public void scorelaUP(){
		scorela.setText(GameSet.getScore().toString());
	}
}
