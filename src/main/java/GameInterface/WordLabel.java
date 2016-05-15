package GameInterface;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WordLabel extends JLabel{
	private int item=0;
	
	private int randItem(){
		double rand=Math.random();
		if(rand<0.4)
			return 1;
		else 
			return 0;
	}
	
	public WordLabel(String text){
		super(text);
		this.setSize(100,40);
		item=randItem();
			
		if(item!=0)
			setHaveItem();
		else
			setKorean();
	}
	
	public int getHaveItem(String korean){
		return 	item;
	}
	
	public void setHaveItem(){
		this.setFont(new Font("굴림",Font.BOLD,20));
	}
	public void setKorean(){
		this.setFont(new Font("굴림",Font.PLAIN,15));
	}
	
	public void setEnglish(){
		this.setFont(new Font("굴림",Font.BOLD,20));
	}

}
