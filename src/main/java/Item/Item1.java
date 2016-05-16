package Item;

import javax.swing.JButton;

import GameInterface.WordLabelArray;
import GameInterface.SuccessWord;
import MyDictionary.MyDictionary;

//모두 지우기 아이템
public class Item1{
	private static JButton btn=new JButton("모두 지우기");
	private static boolean enable=false;
	
	//item1 초기화
	public static void init(){
		setEnable(false);
	}
	
	//item1 실행  - 모두 지우기
	public static void call(){
		//떨어지는 모든 단어를 보이지 않게
		for(int index=0; index<WordLabelArray.getNumOfLabel();index++){
			WordLabelArray.get(index).setVisible(false);
		}
		
		//떨어지는 모든 단어를 성공 단어에 추가
		for(int index=0; index<WordLabelArray.getNumOfLabel();index++){
			//case 1: 한글 입력상태에서 아이템 사용
			//case 2: 영문 입력상테에서 아이템 사용
			String text=WordLabelArray.getText(index);
			String renderText=MyDictionary.render(text);
			
			//case2의 경우 - 모든 떨어지는 라벨 중 하나의 라벨은 영어를 가지고있음
			if(renderText==null){
				renderText=text;
				text=MyDictionary.renderReverse(renderText);
			}
		
			SuccessWord.add(text,renderText);
		}
		
		//모든 떨어지는 라벨 제거
		WordLabelArray.removeAll();
		
		//item1 사용 불가 상태로
		setEnable(false);
	}
	
	//상태값 리턴
	public static boolean getEnable(){
		return enable;
	}
	
	//버튼 리턴
	public static JButton getBtn(){
		return btn;
	}
	
	//상태값 세팅
	public static void setEnable(boolean enable){
		Item1.enable=enable;
		btn.setEnabled(enable);
	}
}
