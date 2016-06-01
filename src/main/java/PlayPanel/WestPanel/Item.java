package PlayPanel.WestPanel;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import Interface.GameSet;
import MainFrame.MainFrame;
import MyDictionary.MyDictionary;
import PlayPanel.CenterPanel.FallWordLabel;
import StartFrame.StartFrame;

public abstract class Item{
	private boolean enable;
	
	Item(){	enable=false;}	
	public abstract void call(); //item 사용	
	public boolean getEnable(){	return enable;}	//상태값 리턴
	public void setEnable(boolean enable){	this.enable=enable;	}//상태값 세팅
}

class Item1 extends Item{
	public void call() {
		Vector<FallWordLabel> fallWordLabelArray = MainFrame.mf.playPa.cp.getLabelArray();
		String korean;
		String english;
		
		//떨어지는 모든 단어를 보이지 않게  && 무효하게		
		for(int index=0; index<fallWordLabelArray.size();index++){
			fallWordLabelArray.get(index).setVisible(false);
			fallWordLabelArray.get(index).setValid(false);
		}
				
		//떨어지는 모든 단어를 성공 단어에 추가
		for(int index=0; index<fallWordLabelArray.size();index++){
			//case 1: 한글 입력상태에서 아이템 사용
			//case 2: 영문 입력상테에서 아이템 사용
			FallWordLabel la=fallWordLabelArray.get(index);
			
			korean=la.getText();
			english=MyDictionary.render(korean);
					
			//case2의 경우 - 모든 떨어지는 라벨 중 하나의 라벨은 영어를 가지고있음
			if(la.getLanguage()==false){
				english=korean;
				korean=MyDictionary.renderReverse(english);
			}
			
			//성공 단어에 추가
			MainFrame.mf.playPa.ep.successWordPanel.successWordTable.add(korean,english);
		}
				
		//모든 떨어지는 라벨 제거
		MainFrame.mf.playPa.cp.getLabelArray().removeAllElements();		
				
		//item1 사용 불가 상태로
		setEnable(false);
	}
}

class Item2 extends Item{
	public void call() {
		setEnable(false);
		GameSet.setStop();
		
		Timer t= new Timer(false);
		TimerTask repairTask=new RepairTask();
		
		//7초후에 원래 속도로
		t.schedule(repairTask, 7000);

		//item3 사용 불가 상태로
		setEnable(false);
	}
	
	class RepairTask extends TimerTask{
		public void run() {
			GameSet.setPlay();
		}
	}
}

class Item3 extends Item{
	double speed;
	public void call() {
		speed=GameSet.getSpeed();
		GameSet.setSpeed(5.0);
		
		Timer t= new Timer(false);
		TimerTask repairTask=new RepairTask();
		
		//7초후에 원래 속도로
		t.schedule(repairTask, 7000);

		//item3 사용 불가 상태로
		setEnable(false);
	}
	
	class RepairTask extends TimerTask{
		public void run() {
			GameSet.setSpeed(speed);
		}
	}
}

class Item4 extends Item{
	public void call() {
		MainFrame.mf.playPa.cp.heartGagePa.heartgage.fullgain();
		setEnable(false);
	}	
}
