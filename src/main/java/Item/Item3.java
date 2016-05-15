package Item;

import javax.swing.JButton;

public class Item3{
	private static boolean enable=false;
	private static JButton btn=new JButton("F3");
	
	public static void init(){
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
