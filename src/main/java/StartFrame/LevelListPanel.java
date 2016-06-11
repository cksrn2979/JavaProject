package StartFrame;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import Graphics.GraphicRadioButton;

public class LevelListPanel extends JPanel{
	public String level;	
	GraphicRadioButton levelbtn[];
	ButtonGroup levelGroup;
	LevelListPanel(){			
		setBackground(null);
		makeBtn();
	}
	
	void makeBtn(){
		levelGroup=new ButtonGroup();
		levelbtn=new GraphicRadioButton[3];
		levelbtn[0]= new GraphicRadioButton("images/StartFrame/","levelBtn1",70,35);
		levelbtn[1]= new GraphicRadioButton("images/StartFrame/","levelBtn2",70,35);
		levelbtn[2]= new GraphicRadioButton("images/StartFrame/","levelBtn3",70,35);
		
		for(int i=0; i<3;i++){
			levelGroup.add(levelbtn[i]);
			add(levelbtn[i]);
		}
	}	
}