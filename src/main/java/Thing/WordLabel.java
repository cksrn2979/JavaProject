package Thing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WordLabel extends JLabel{
	
	public WordLabel(String text){
		super(text);
		this.setSize(100,40);
		if(FallWordLabel.getHaveItem(text)!=0)
			setHaveItem();
		else
			setKorean();
	}
	
	public void setHaveItem(){
		this.setFont(new Font("굴림",Font.BOLD,20));
	}
	public void setKorean(){
		this.setFont(new Font("굴림",Font.PLAIN,15));
	}
	
	public void setEnglish(){
		this.setFont(new Font("굴림",Font.BOLD,20));
		setOpaque(true);
		setBackground(null);
		setForeground(Color.BLUE);
	}

}
