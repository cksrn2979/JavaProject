package StartFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Graphics.GlobalGraphic;
import Graphics.GraphicButton;
import Graphics.GraphicRadioButton;
import MainFrame.MainFrame;
import PlayPanel.PlayPanel;

public class SubmitPanel extends JPanel{
	MainFrame mf;
	String user;
	String character;	
	GraphicButton[] submitBtn;
	
	SubmitPanel(MainFrame mf){
		this.mf=mf;
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
			StartFrame startFrame=(StartFrame)SubmitPanel.this.getTopLevelAncestor();
			GraphicButton btn=(GraphicButton)e.getSource();
			if(btn.getFILENAME()=="SubmitBtn"){
				
				String[] spliter;
				
				String selection=(String)startFrame.userListPa.getSelectedItem();
				if(selection==null){
					JOptionPane.showMessageDialog(null, "유저를 선택해주세요", "경고!",JOptionPane.WARNING_MESSAGE);
					return;
				}
				spliter=selection.split("\t");
				
				character=spliter[0];
				user=spliter[1];
				int level = 0;
				double speed = 0;
				
				
				String levelbtn = null;
				Enumeration<AbstractButton> enums = startFrame.levelListPa.levelGroup.getElements();
				while(enums.hasMoreElements()){
					 GraphicRadioButton radiobtn=(GraphicRadioButton)enums.nextElement(); 
					 if(radiobtn.isSelected())    
						 levelbtn=radiobtn.getFILENAME();
				}
				
				switch(character){
				case "MUZI.": GlobalGraphic.character=new Color(251,233,13); 
						GlobalGraphic.path="images/MainFrame/Muzi/";
						character="MUZI";
						break;
				case "LYAN.": GlobalGraphic.character=new Color(215,209,137);
						GlobalGraphic.path="images/MainFrame/Lyan/";
						character="LYAN";
						break;
				case "APEACH.": GlobalGraphic.character=new Color(247,171,171);
						GlobalGraphic.path="images/MainFrame/Apeach/";
						 character="APEACH";
						break;
				}
				
				if(levelbtn==null){
					JOptionPane.showMessageDialog(null, "레벨을 선택해주세요", "경고!",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				switch(levelbtn){
					case "levelBtn1": level=1; break;
					case "levelBtn2": level=4; break;
					case "levelBtn3": level=6; break;
				}
				
				mf.setContentPane(mf.playPanel=new PlayPanel(new StartInfo(user,character,level)));
			}
			
			else;
			JFrame topFrame=(JFrame)(SubmitPanel.this.getTopLevelAncestor());
			topFrame.dispose();
			
		}
	}
}	