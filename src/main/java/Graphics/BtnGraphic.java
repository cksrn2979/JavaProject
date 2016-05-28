package Graphics;

import java.awt.Color;

import javax.swing.JLabel;

import Interface.GameFontB;

public class BtnGraphic extends GraphicForm{
	JLabel la=new JLabel("");
	
	public BtnGraphic(String path, String btnID, int width, int height) {
		super(path, btnID, width, height);
	}
	
	public void addla(String s, int size){
		la.setText(s);
		la.setFont(new GameFontB(size));
		this.add(la);
	}
	
	public void setLaColor(Color c){la.setForeground(c);}
	
}