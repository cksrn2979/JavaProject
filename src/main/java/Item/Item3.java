package Item;

import javax.swing.JButton;

public class Item3{
	private static boolean enable=false;
	private static JButton btn=new JButton("느리게");
	
	public static void init(){
		setEnable(false);
	}
	public static void call(){
		//item3 사용 불가 상태로
				setEnable(false);
	}
	public static boolean getEnable(){
		return enable;
	}
	
	public static JButton getBtn(){
		return btn;
	}
	public static void setEnable(boolean enable){
		Item3.enable=enable;
		btn.setEnabled(enable);
	}
}
