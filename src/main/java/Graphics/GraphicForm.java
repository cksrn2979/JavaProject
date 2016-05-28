package Graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicForm extends JPanel{
	ImageIcon imgIcon;
	String path;
	String btnID;
	
	public GraphicForm(String path, String btnID, int width, int height){
		imgIcon=new ImageIcon(path+".png");
		setSize(width,height);
		this.path=path;
		this.btnID=btnID;
	}
	
	public ImageIcon getimgIcon(){return imgIcon;}
	public String getPath(){return path;}
	public String getID(){return btnID;}	
	
	public void setImgIcon(String p){imgIcon = new ImageIcon(p);}	
	
	public void paintComponent(Graphics g) {
		g.drawImage(imgIcon.getImage(), 0, 0, null);	
		setOpaque(false);
		super.paintComponent(g);
	}
}