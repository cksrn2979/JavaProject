package CenterPanel;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;


//떨어지는 라벨들의 집합
public class FallWordLabelArray{ 
	
	private static Vector<FallWordLabel> list= new Vector<FallWordLabel>();

	public static void add(FallWordLabel wla){
		list.add(wla);
	}
	
	//라벨의 갯수를 얻음
	public static int getNumOfLabel(){
		return list.size();
	}
	
	//text 의 index 얻음
	public static int getIndex(String text){
		return list.indexOf(text);
	}
	
	//index 번째 Label을 얻음
	public static FallWordLabel get(int index){
		return list.elementAt(index);		
	}
	
	//index번째 텍스트를 얻음
	public static String getText(int index){
		return list.elementAt(index).getText();		
	}
	
	
	//index번째 텍스트를 셋팅
	public static void setText(int index, String text){
		list.elementAt(index).setText(text);	
	}
	
	//집합에서 삭제
	public static void remove(int index){
		list.remove(index);	
	}
	
	//집합에서 삭제
	public static void remove(FallWordLabel wla){
		list.remove(wla);	
	}
	
	//모두 삭제
	public static void removeAll(){
		list.removeAllElements();
	}
	
}
