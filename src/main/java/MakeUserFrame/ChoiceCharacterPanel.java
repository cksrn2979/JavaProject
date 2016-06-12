package MakeUserFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.GraphicRadioButton;

class ChoiceCharacterPanel extends JPanel{
	JLabel choicela;
	GraphicRadioButton[] choiceBtn;
	ButtonGroup chracterGroup;
		
	ChoiceCharacterPanel(){
		this.setSize(400, 250);
		
		setBackground(null);				
					
		makeBtn();
			
	}
		
	void makeBtn(){
		chracterGroup=new ButtonGroup(); 
		
		String path="images/MakeUserFrame/";			
		choiceBtn=new GraphicRadioButton[3];
		choiceBtn[0] =new GraphicRadioButton(path,"MuziBtn",100,100);
		choiceBtn[1] =new GraphicRadioButton(path,"LyanBtn",100,100);
		choiceBtn[2] =new GraphicRadioButton(path,"ApeachBtn",100,100);
		
		for(int i=0; i<3; i++){
			choiceBtn[i].addActionListener( new ChoiceActionListener());
		}
	
		for(int i=0; i<3; i++){
			chracterGroup.add(choiceBtn[i]);
			add(choiceBtn[i]);
		}
	}
	
	class ChoiceActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			GraphicRadioButton btn=(GraphicRadioButton)e.getSource();
			
		}
	}
}