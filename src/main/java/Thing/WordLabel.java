package Thing;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WordLabel extends JLabel{
	public static HashMap<String,Integer> haveItem = new HashMap<String,Integer>();
	
	private static int randItem(){
		double rand=Math.random();
		if(rand<0.4)
			return 1;
		else 
			return 0;
	}
	
	public WordLabel(String text){
		super(text);
		this.setSize(100,40);
		Integer item=new Integer(randItem());
		haveItem.put(text,item);
		
		if(haveItem.get(text)!=0)
			setHaveItem();
		else
			setKorean();
	}
	
	public static int getHaveItem(String korean){
		return 	haveItem.get(korean).intValue();
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
