package StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Graphics.GraphicButton;
import Interface.GameColor;
import Interface.GameSet;
import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class SubmitPanel extends JPanel{
	
	String user;
	String character;	
	GraphicButton[] submitBtn;
	
	SubmitPanel(){
		setLayout(null);
		setBackground(null);
		makeBtn();
	}
	
	void makeBtn(){
		String path="images/StartFrame/";
		submitBtn=new GraphicButton[2];
		submitBtn[0] =new GraphicButton(path,"SubmitBtn",100,35);
		submitBtn[1] =new GraphicButton(path,"ConcealBtn",100,35);
		
		for(int i=0; i<2; i++){
			submitBtn[i].addActionListener(new SubmitAction());
		}
		
		for(int i=0; i<2; i++){
			submitBtn[i].setLocation(40+(i*120),0);
			add(submitBtn[i]);
		}
	}
	
	
	class SubmitAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GraphicButton btn=(GraphicButton)e.getSource();
			if(btn.getFILENAME()=="SubmitBtn"){
				String[] spliter;
				String item=(String)MainFrame.mf.startFra.userListPa.getSelectedItem();
			
				spliter=item.split("\t");
				
				character=spliter[0];
				user=spliter[1];					
				GameSet.setUser(user);
				GameSet.setCharacter(character);
				
				if(character.equals("MUZI"))
				{	GameColor.character=GameColor.muzi; 
					GameSet.setPath("images/MainFrame/Muzi/");
				}
				else if(character.equals("LYAN"))
				{	GameColor.character=GameColor.lyan;
					GameSet.setPath("images/MainFrame/Lyan/");
				}
				else if(character.equals("LYAN"))
				{
					GameColor.character=GameColor.apeach;
					GameSet.setPath("images/MainFrame/Apeach/");
				}

				
//				switch(character){
//					case "MUZI.": GameColor.character=GameColor.muzi; 
//								GameSet.setPath("images/MainFrame/Muzi/");
//								break;
//					case "LYAN.": GameColor.character=GameColor.lyan;
//								GameSet.setPath("images/MainFrame/Lyan/");
//								break;
//					case "APEACH.": GameColor.character=GameColor.apeach;
//								GameSet.setPath("images/MainFrame/Apeach/");
//								break;
//				}		
			
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