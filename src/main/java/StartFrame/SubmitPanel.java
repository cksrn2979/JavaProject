package StartFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import Graphics.BtnGraphic;
import Graphics.BtnGraphicAction;
import Graphics.GraphicForm;
import Interface.GameColor;
import Interface.GameSet;
import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class SubmitPanel extends JPanel{
	
	String user;
	String character;	
	BtnGraphic[] submitBtn;
	
	SubmitPanel(){
		this.setPreferredSize(new Dimension(400,50));
		setLayout(null);
		setBackground(GameColor.frame1);
		makeBtn();
		
		for(int i=0; i<2; i++){
			submitBtn[i].setLocation(90+(i*120),0);
			add(submitBtn[i]);
		}
	}
	
	void makeBtn(){
		String path="images/MakeUserFrame/ChoiceCharacter";
		submitBtn=new BtnGraphic[2];
		submitBtn[0] =new BtnGraphic(path+"/SelectBtn","submit",100,35);
		submitBtn[1] =new BtnGraphic(path+"/SelectBtn","conceal",100,35);
		
		submitBtn[0].addla("확인", 17);
		submitBtn[1].addla("취소", 17);
		BtnGraphicAction action=new SubmitAction();
		submitBtn[0].addMouseListener(action);
		submitBtn[1].addMouseListener(action);
	}
	
	class SubmitAction extends BtnGraphicAction {
		public void clickAct(BtnGraphic btn) {
			if(btn.getID()=="submit"){
				String[] spliter;
				String item=(String)MainFrame.mf.startFra.choiceUserPa.userList.getSelectedItem();
			
				spliter=item.split("\t");
				
				character=spliter[0];
				user=spliter[1];					
				GameSet.setUser(user);
				GameSet.setCharacter(character);
				
				if(character.equals("Muzi"))
					GameColor.character=GameColor.muzi;
				else if(character.equals("Lyan"))
					GameColor.character=GameColor.lyan;
				else if(character.equals("Apeach"))
					GameColor.character=GameColor.apeach;
				
//				switch(character){
//					case "Muzi.": GameColor.character=GameColor.muzi; break;
//					case "Lyan.": GameColor.character=GameColor.lyan; break;
//					case "Apeach.": GameColor.character=GameColor.apeach; break;
//				}
				
				if(MainFrame.mf.startFra.choiceLevelPa.level.equals("level1"))
					{
					GameSet.setLevel(1); GameSet.setSpeed(5.0); 
					}
				else if(MainFrame.mf.startFra.choiceLevelPa.level.equals("level2"))
					{
					GameSet.setLevel(2); GameSet.setSpeed(10.0);
					}
				else if(MainFrame.mf.startFra.choiceLevelPa.level.equals("level3"))
					{
					GameSet.setLevel(3); GameSet.setSpeed(15.0);
					}
				else if(MainFrame.mf.startFra.choiceLevelPa.level.equals("level4"))
					{
					GameSet.setLevel(4); GameSet.setSpeed(20.0);
					}
				else if(MainFrame.mf.startFra.choiceLevelPa.level.equals("level5"))
					{
					GameSet.setLevel(5); GameSet.setSpeed(25.0);
					}
				else if(MainFrame.mf.startFra.choiceLevelPa.level.equals("level6"))
					{
					GameSet.setLevel(6); GameSet.setSpeed(30.0);
					}
				
//				switch(MainFrame.mf.startFra.choiceLevelPa.level){
//					case "level1": GameSet.setLevel(1); GameSet.setSpeed(5.0); break;
//					case "level2": GameSet.setLevel(2); GameSet.setSpeed(10.0);break;
//					case "level3": GameSet.setLevel(3); GameSet.setSpeed(15.0);break;
//					case "level4": GameSet.setLevel(4); GameSet.setSpeed(20.0);break;
//					case "level5": GameSet.setLevel(5); GameSet.setSpeed(25.0);break;
//					case "level6": GameSet.setLevel(6); GameSet.setSpeed(30.0);break;
//				}				
				MainFrame.mf.setContentPane(MainFrame.mf.playPa=new PlayPanel());
			}
			
			else;
			MainFrame.mf.startFra.dispose();
		}
	}
}	