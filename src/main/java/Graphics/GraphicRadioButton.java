package Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		setIcon(new ImageIcon(path+FILENAME+".png"));
		this.setSelectedIcon(new ImageIcon(path+FILENAME+"_select" + ".png"));
		setOpaque(false);
		setBorderPainted(false);		
		setFocusPainted(false);
		setContentAreaFilled(false);		
		setSize(width,height);
		
		this.addMouseListener(new BtnMouseListener());
	}
	
	public class BtnMouseListener implements MouseListener{
		
		public void mouseEntered(MouseEvent e) {
			GraphicRadioButton btn=(GraphicRadioButton)e.getSource();
			btn.setIcon(new ImageIcon(path+FILENAME + "_enter"+ ".png"));
			btn.repaint();
		}
	
		public void mouseExited(MouseEvent e) {
			GraphicRadioButton btn=(GraphicRadioButton)e.getSource();
			btn.setIcon(new ImageIcon(path+FILENAME+".png"));		
			btn.repaint();
		}		
		public void mousePressed(MouseEvent e) {
			
		}		
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e){}
	
	}
}