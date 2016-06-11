package Graphics;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public 	class GraphicRadioButton extends JRadioButton{
	private String path;
	private String FILENAME;
	public String getPath(){return path;}
	public String getFILENAME(){return FILENAME;}
	
	public GraphicRadioButton(String path, String FILENAME,int width,int height){
		this.path=path;
		this.FILENAME=FILENAME;
		
		setOpaque(false);
		setBorderPainted(false);		
		setFocusPainted(false);
		setContentAreaFilled(false);		
		setSize(width,height);
		
		setIcon(new ImageIcon(path+FILENAME+".png"));
		setSelectedIcon(new ImageIcon(path+FILENAME+"_select" + ".png"));
		setRolloverIcon(new ImageIcon(path+FILENAME + "_enter"+ ".png"));
	}
}