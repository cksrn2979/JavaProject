package PlayPanel.NorthPanel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.GraphicForm;
import Interface.GameColor;
import Interface.GameFontB;
import Interface.GameSet;

public class NorthPanel extends JPanel{
	private JLabel levella;
	private JLabel scorela;
	private LevelGraphic levelGra;
	private ScoreGraphic scoreGra;
	
	public NorthPanel(){
		setBackground(GameColor.character);
		setPreferredSize(new Dimension(800,60));
		setLayout(null);
		String path="images/MainFrame/"+GameSet.getCharacter() +"/PlayPanel/NorthPanel/";
		levelGra=new LevelGraphic(path+"levelGra","levelGra",130,50);
		scoreGra=new ScoreGraphic(path+"ScoreGra","scoreGra",130,50);
		
		levelGra.setLocation(250,0);
		scoreGra.setLocation(400,0);
		add(levelGra);
		add(scoreGra);
		
		
	}
	
	public void paintComponent(Graphics g) {
		String path="images/MainFrame/"+GameSet.getCharacter() +"/PlayPanel/NorthPanel/";
		ImageIcon imgIcon=new ImageIcon(path+"background"+".png");
		g.drawImage(imgIcon.getImage(), 0, 0, null);	
		setOpaque(false);
		super.paintComponent(g);
	}
	
	class LevelGraphic extends GraphicForm{
		public LevelGraphic(String path, String btnID, int width, int height) {
			super(path, btnID, width, height);
			setLayout(null);
			levella = new JLabel(GameSet.getLevel().toString());
			levella.setFont(new GameFontB(17));
			levella.setSize(100,40);
			levella.setLocation(90,8);
			add(levella);
		}
		
	}
	
	class ScoreGraphic extends GraphicForm{
		public ScoreGraphic(String path, String btnID, int width, int height) {
			super(path, btnID, width, height);
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
