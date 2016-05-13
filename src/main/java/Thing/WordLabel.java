package Thing;

import java.awt.Font;

import javax.swing.JLabel;

public class WordLabel extends JLabel{
	
	WordLabel(){
		this.setSize(60,40);		
	}
	
	public void setKorean(){
		this.setFont(new Font("굴림",Font.PLAIN,30));
	}
	
	public void setEnglish(){
		this.setFont(new Font("굴림",Font.BOLD,40));
	}

}
