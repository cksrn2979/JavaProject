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
		setIcon(new ImageIcon(path+FILENAME+".png"));
		setOpaque(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		this.setSize(width,height);
		this.addMouseListener(new BtnMouseListener());
	}
	

	public class BtnMouseListener implements MouseListener{
			
		public void mouseEntered(MouseEvent e) {
			GraphicButton btn=(GraphicButton)e.getSource();
			btn.setIcon(new ImageIcon(path+FILENAME+ "_enter"+ ".png"));
			btn.repaint();
		}
	
		public void mouseExited(MouseEvent e) {
			GraphicButton btn=(GraphicButton)e.getSource();
			btn.setIcon(new ImageIcon(path+FILENAME+".png"));		
			btn.repaint();
		}
		
		public void mousePressed(MouseEvent e) {
			GraphicButton btn=(GraphicButton)e.getSource();
			btn.setIcon(new ImageIcon(path+FILENAME+ ".png"));
			btn.repaint();		
		}
		
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e){}
	
	}
}