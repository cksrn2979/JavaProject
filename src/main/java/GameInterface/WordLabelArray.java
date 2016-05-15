package GameInterface;

import java.util.HashMap;
import java.util.Vector;

import MyDictionary.MyDictionary;

public class WordLabelArray{
	public static Vector<WordLabel> list= new Vector<WordLabel>();

	public static void add(WordLabel wla){
		list.add(wla);
	}
	
	//라벨의 갯수를 얻음
	public static int getNumOfLabel(){
		return list.size();
	}
	
	//index 번째 Label을 얻음
	public static WordLabel getLabel(int index){
		return list.elementAt(index);		
	}
	
	
	//index번째 텍스트를 얻음
	public static String getLabelText(int index){
		return list.elementAt(index).getText();		
	}
	
	
	//index번째 텍스트를 셋팅
	public static void setLabelText(int index, String text){
		list.elementAt(index).setText(text);	
	}
	
	public static void remove(int index){
		list.remove(index);	
	}
	
	public static void remove(WordLabel wla){
		list.remove(wla);	
	}
	
	public static void removeAll(){
		list.removeAllElements();
	}
	
}
