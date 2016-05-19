package MainFrame.CenterPanel;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;


//떨어지는 라벨들의 집합
public class FallWordLabelArray{ 
	
	private Vector<FallWordLabel> list= new Vector<FallWordLabel>();

	public void add(FallWordLabel wla){
		list.add(wla);
	}
	
	//라벨의 갯수를 얻음
	public int getNumOfLabel(){
		return list.size();
	}
	
	//text 의 index 얻음
	public int getIndex(String text){
		return list.indexOf(text);
	}
	
	//index 번째 Label을 얻음
	public FallWordLabel getLabel(int index){
		return list.elementAt(index);		
	}
	
	//index번째 텍스트를 얻음
	public String getText(int index){
		return list.elementAt(index).getText();		
	}
	
	
	//index번째 텍스트를 셋팅
	public void setText(int index, String text){
		list.elementAt(index).setText(text);	
	}
	
	//집합에서 삭제
	public void remove(int index){
		list.remove(index);	
	}
	
	//집합에서 삭제
	public void remove(FallWordLabel wla){
		list.remove(wla);	
	}
	
	//모두 삭제
	public void removeAll(){
		list.removeAllElements();
	}
	
}
