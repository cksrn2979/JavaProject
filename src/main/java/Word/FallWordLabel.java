package Word;

import java.util.Vector;

import Thing.WordLabel;

public class FallWordLabel{
	public static Vector<WordLabel> list= new Vector<WordLabel>();
	
	public static void add(int n){
		for(int i=0; i<n; i++){
			String wla=new String(Word.get());
			list.add(new WordLabel(wla));
		}
	}
	
	public static WordLabel get(int index){
		return list.elementAt(index);		
	}
	
	public static String getText(int index){
		return list.elementAt(index).getText();		
	}
	
	public static void setText(int index, String text){
		list.elementAt(index).setText(text);	
	}
	
	public static void remove(int index){
		list.remove(index);	
	}
	
}
