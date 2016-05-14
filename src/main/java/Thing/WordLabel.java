package Thing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WordLabel extends JLabel{
	
	public WordLabel(String string){
		super(string);
		this.setSize(100,40);
		setKorean();
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
