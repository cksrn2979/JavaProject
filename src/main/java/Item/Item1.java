package Item;

import javax.swing.JButton;

import GameInterface.SuccessWord;
import GameInterface.WordLabelArray;
import MyDictionary.MyDictionary;

public class Item1{
	private static JButton btn=new JButton("모두 지우기");
	private static boolean enable=false;
	
	public static void init(){
		setEnable(false);
	}
	
	public static void call(){
		for(int index=0; index<WordLabelArray.getNumOfLabel();index++){
			WordLabelArray.getLabel(index).setVisible(false);
		}
		
		for(int index=0; index<WordLabelArray.getNumOfLabel();index++){
			String korean=WordLabelArray.getLabelText(index);
			String english=MyDictionary.render(korean);
			
			if(english==null){
				english=korean;
				korean=MyDictionary.renderReverse(english);
			}
		
			SuccessWord.add(korean,english);
		}
		
		WordLabelArray.removeAll();
		
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
