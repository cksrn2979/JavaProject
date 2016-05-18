package CenterPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class FallWordLabel extends JLabel{
	//라벨의 Item 보유  
	private boolean itemHave = false;
	
	//라벨의 유효성
	private boolean valid=true;
	
	 //Item랜덤하게 생성
	private int randItem(){		
		double rand=Math.random();
		//10%확률로 아이템 생성
		if(rand<0.1){
			itemHave=true;
		}	
		return 0;
	}

	public FallWordLabel(String text){
		super(text);
		this.setSize(100,40);
		randItem(); //Item랜덤하게 생성
			
		if(itemHave)
			setHaveItem_k(); //Item을 가지고 있을때의 폰트
		else
			setKorean(); //한글 폰트
	}
	
	//Item 리턴
	public boolean getHaveItem(){
		return  itemHave;
	}
	
	//Item 가지고 있을때 한글 폰트
	public void setHaveItem_k(){
		this.setFont(new Font("굴림",Font.BOLD,20));
	}
	
	//Item 가지고 있을 때 영어 폰트
	public void setHaveItem_e(){
		this.setFont(new Font("굴림",Font.BOLD,20));
		this.setForeground(Color.blue);
	}

	//한글 폰트
	public void setKorean(){
		this.setFont(new Font("굴림",Font.PLAIN,15));
	}
	
	//영문 폰트
	public void setEnglish(){
		this.setFont(new Font("굴림",Font.BOLD,15));
		this.setForeground(Color.blue);//영단어 입력시 글자색 변경
	}
	
	//유효성 리턴
	public boolean getValid(){
		return valid;
	}
	
	public void setValid(boolean valid){
		this.valid=valid;
	}

}