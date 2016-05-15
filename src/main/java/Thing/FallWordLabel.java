package Thing;

import java.util.HashMap;
import java.util.Vector;

import MyDictionary.MyDictionary;

public class FallWordLabel{
	public static Vector<WordLabel> list= new Vector<WordLabel>();
	public static HashMap<String,Integer> haveItem = new HashMap<String,Integer>();
	
	private static int randItem(){
		double rand=Math.random();
		if(rand<0.4)
			return 1;
		else 
			return 0;
	}
	
	public static void add(WordLabel wla){
		list.add(wla);
	}
	
	public static void add(int n){
		for(int i=0; i<n; i++){
			String wla=new String(MyDictionary.rand());
			Integer item=new Integer(randItem());
			list.add(new WordLabel(wla));
			haveItem.put(wla,item);
		}
	}
	
	public static int getNumOfLabel(){
		return list.size();
	}
	public static WordLabel get(int index){
		return list.elementAt(index);		
	}
	
	public static int getHaveItem(String korean){
		return 	haveItem.get(korean).intValue();
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
