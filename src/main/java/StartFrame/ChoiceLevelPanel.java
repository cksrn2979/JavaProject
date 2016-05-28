package StartFrame;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Graphics.BtnGraphic;
import Graphics.BtnGraphicActionMainTain;
import Graphics.GraphicForm;
import Interface.GameColor;

public class ChoiceLevelPanel extends JPanel{
	public String level;	
	JPanel clp= new JPanel();
	BtnGraphic levelbtn[];
	
	ChoiceLevelPanel(){
		setPreferredSize(new Dimension(200,150));
		setBackground(GameColor.frame1);
		
		add(clp);
		clp.setPreferredSize(new Dimension(200,150));
		clp.setBackground(null);
		clp.setLayout(new GridLayout(2,3,0,0));		
		
		makeBtn();
		for(int i=0; i<6;i++){
			levelbtn[i].setLocation(50,i*50);
			clp.add(levelbtn[i]);
		}
	}
	
	void makeBtn(){
		String path="C:/Workspace/JavaProject/images/StartFrame/ChoiceLevelPanel";
		
		levelbtn=new BtnGraphic[6];
		levelbtn[0]= new BtnGraphic(path+"/levelBtn","level1",50,50);
		levelbtn[1]= new BtnGraphic(path+"/levelBtn","level2",50,50);
		levelbtn[2]= new BtnGraphic(path+"/levelBtn","level3",50,50);
		levelbtn[3]= new BtnGraphic(path+"/levelBtn","level4",50,50);
		levelbtn[4]= new BtnGraphic(path+"/levelBtn","level5",50,50);
		levelbtn[5]= new BtnGraphic(path+"/levelBtn","level6",50,50);
		
		levelbtn[0].addla("1",20);
		levelbtn[1].addla("2",20);
		levelbtn[2].addla("3",20);
		levelbtn[3].addla("4",20);
		levelbtn[4].addla("5",20);
		levelbtn[5].addla("6",20);
		
		for(int i=0; i<6; i++)
			levelbtn[i].addMouseListener(new LevelBtnAciton());
	}
	
	class LevelBtnAciton extends BtnGraphicActionMainTain{
		public void clickAct(BtnGraphic btn) {
			level=this.getChoice();
		}
		
	}
	
}