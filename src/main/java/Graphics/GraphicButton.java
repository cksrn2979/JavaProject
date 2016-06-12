package Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public 	class GraphicButton extends JButton{
	String path;
	String FILENAME;
	public String getPath(){return path;}
	public String getFILENAME(){return FILENAME;}
	
	public GraphicButton(String path, String FILENAME,int width,int height){
		this.path=path;
		this.FILENAME=FILENAME;
		
		setOpaque(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		this.setSize(width,height);
			
		setIcon(new ImageIcon(path+FILENAME+".png"));
		setRolloverIcon(new ImageIcon(path+FILENAME+ "_enter"+ ".png"));
	}

}