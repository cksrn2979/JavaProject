package Graphics;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Interface.GameColor;

public abstract class BtnGraphicActionMainTain implements MouseListener{
	String choice;
	boolean press=false;
		
	public void mouseEntered(MouseEvent e) {
		if(press==false){
			BtnGraphic btn=(BtnGraphic)e.getSource();
			btn.setImgIcon(btn.getPath()+ "_enter"+ ".png");
			btn.setLaColor(GameColor.basic);
			btn.repaint();
		}
	}

	public void mouseExited(MouseEvent e) {
		if(press==false){
			BtnGraphic btn=(BtnGraphic)e.getSource();
			btn.setImgIcon(btn.getPath()+".png");
			btn.setLaColor(GameColor.enter);
			btn.repaint();
		}
	}
	
	public void mousePressed(MouseEvent e) {
		BtnGraphic btn=(BtnGraphic)e.getSource();
		
		if(press){
			System.out.println("1");
			btn.setImgIcon(btn.getPath() + ".png");
			btn.setLaColor(GameColor.enter);
			press=false;
		}
	
		else if(press==false) {
			System.out.println("3");
			btn.setImgIcon(btn.getPath()+ "_press"+ ".png");
			btn.setLaColor(GameColor.basic);
			choice=btn.getID();
			press=true;
			System.out.println(choice);
			clickAct(btn);
		}
			
		btn.repaint();		
		
	}
	
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	
	public String getChoice(){return choice;}
	abstract public void clickAct(BtnGraphic btn);

}

