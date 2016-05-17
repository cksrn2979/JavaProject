package GameInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Item.Item1;
import Item.Item2;
import Item.Item3;

public class WordLabel extends JLabel{
	//라벨의 Item 보유  
	private int item = 0;
	
	//라벨의 유효성
	private boolean valid=true;
	
	 //Item랜덤하게 생성
	private int randItem(){		
		double rand=Math.random();
		//10%확률로 아이템 생성
		if(rand<0.1){
			Boolean chkEnable[]=new Boolean[3];
			chkEnable[0]=Item1.getEnable();
			chkEnable[1]=Item2.getEnable();
			chkEnable[2]=Item3.getEnable();
			//chkEnable[3]=Item4.getEnable();
			for(int i=0;i<3;i++)
				if(chkEnable[i]==false)
					return i+1;
		}
	
		return 0;
	}

	public WordLabel(String text){
		super(text);
		this.setSize(100,40);
		item=randItem(); //Item랜덤하게 생성
			
		if(item!=0)
			setHaveItem_k(); //Item을 가지고 있을때의 폰트
		else
			setKorean(); //한글 폰트
	}
	
	//Item 리턴
	public int getHaveItem(String korean){
		return  item;
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
