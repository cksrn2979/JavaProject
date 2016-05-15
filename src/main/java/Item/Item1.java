package Item;

import javax.swing.JButton;

import MyDictionary.MyDictionary;
import Thing.FallWordLabel;
import Thing.SuccessWord;

public class Item1{
	private static JButton btn=new JButton("모두 지우기");
	private static boolean enable=false;
	
	public static void init(){
		setEnable(false);
	}
	
	public static void call(){
		for(int index=0; index<FallWordLabel.getNumOfLabel();index++){
			FallWordLabel.get(index).setVisible(false);
		}
		
		for(int index=0; index<FallWordLabel.getNumOfLabel();index++){
			String korean=FallWordLabel.getText(index);
			String english=MyDictionary.render(korean);
			
			if(english==null){
				english=korean;
				korean=MyDictionary.renderReverse(english);
			}
		
			SuccessWord.add(korean,english);
		}
		
		for(int index=0; index<FallWordLabel.getNumOfLabel();index++){
			FallWordLabel.remove(index);
		}
		
		setEnable(false);
	}
	
	public static boolean getEnable(){
		return enable;
	}
	
	public static JButton getBtn(){
		return btn;
	}
	
	public static void setEnable(boolean enable){
		Item1.enable=enable;
		btn.setEnabled(enable);
	}
}
