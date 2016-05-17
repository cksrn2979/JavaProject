package Item;

import javax.swing.JButton;

import GameInterface.BasicInterface;

public class Item2{
	private static boolean enable=false;
	private static JButton btn=new JButton("잠깐멈추기");
	
	public static void init(){
		setEnable(false);
	}
	public static void call(){
		
		//item2 사용 불가 상태로
				setEnable(false);
	}
	
	public static boolean getEnable(){
		return enable;
	}
	
	public static JButton getBtn(){
		return btn;
	}
	
	public static void setEnable(boolean enable){
		Item2.enable=enable;
		btn.setEnabled(enable);
	}
}
