package Item;

import javax.swing.JButton;

public class Item2{
	private static boolean enable=false;
	private static JButton btn=new JButton("F2");
	
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
		Item2.enable=enable;
		btn.setEnabled(enable);
	}
}
