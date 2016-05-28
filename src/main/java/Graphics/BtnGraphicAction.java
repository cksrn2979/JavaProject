package Graphics;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import Interface.GameColor;

public abstract class BtnGraphicAction implements MouseListener{
			
	public void mouseEntered(MouseEvent e) {
		BtnGraphic btn=(BtnGraphic)e.getSource();
		btn.setImgIcon(btn.getPath()+ "_enter"+ ".png");
		btn.setLaColor(GameColor.basic);
		btn.repaint();
	}

	public void mouseExited(MouseEvent e) {
		BtnGraphic btn=(BtnGraphic)e.getSource();
		btn.setImgIcon(btn.getPath()+".png");
		btn.setLaColor(GameColor.enter);
		btn.repaint();
	}
	
	public void mousePressed(MouseEvent e) {
		BtnGraphic btn=(BtnGraphic)e.getSource();
		btn.setImgIcon(btn.getPath()+ "_press"+ ".png");
		btn.setLaColor(GameColor.enter);
		btn.repaint();		
		clickAct(btn);
	}
	
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e){}

	abstract public void clickAct(BtnGraphic btn);

}
