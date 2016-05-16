package GameInterface;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WordLabel extends JLabel{
	//라벨의 Item 보유  
	private int item = 0;
	
	 //Item랜덤하게 생성
	private int randItem(){		
		double rand=Math.random();
		//10%확률로 1번 아이템 생성
		if(rand<0.1)
			return 1;
		else 
			return 0;
	}
	
	
	public WordLabel(String text){
		super(text);
		this.setSize(100,40);
		item=randItem(); //Item랜덤하게 생성
			
		if(item!=0)
			setHaveItem(); //Item을 가지고 있을때의 폰트
		else
			setKorean(); //한글 폰트
	}
	
	//Item 리턴
	public int getHaveItem(String korean){
		return  item;
	}
	
	
	//Item 가지고 있을때 폰트
	public void setHaveItem(){
		this.setFont(new Font("굴림",Font.BOLD,20));
	}
	
	//한글 폰트
	public void setKorean(){
		this.setFont(new Font("굴림",Font.PLAIN,15));
	}
	
	
	//영문 폰트
	public void setEnglish(){
		this.setFont(new Font("굴림",Font.BOLD,20));
	}

}
