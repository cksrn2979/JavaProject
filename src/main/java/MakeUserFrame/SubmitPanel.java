package MakeUserFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Dictionary.BasicDictionary;
import Graphics.GraphicButton;
import Graphics.GraphicRadioButton;
import MainFrame.MainFrame;

class SubmitPanel extends JPanel{
	GraphicButton[] submitBtn;
	
	SubmitPanel(){
		setLayout(null);
		setBackground(null);
		makeBtn();
		
		for(int i=0; i<2; i++){
			submitBtn[i].setLocation(90+(i*120),0);
			add(submitBtn[i]);
		}
	}
	
	void makeBtn(){
		String path="images/MakeUserFrame/";
		submitBtn=new GraphicButton[2];
		submitBtn[0] =new GraphicButton(path,"SubmitBtn",100,35);
		submitBtn[1] =new GraphicButton(path,"ConcealBtn",100,35);
		
		
		for(int i=0; i<2;i++){
			submitBtn[i].addActionListener(new SubmitActionListener());
		}
	}
	
	class SubmitActionListener implements ActionListener{
		String chracter;
		MakeUserFrame topFrame;
	
		public void actionPerformed(ActionEvent e) {
			topFrame=(MakeUserFrame)SubmitPanel.this.getTopLevelAncestor();
			
			
			GraphicButton btn=(GraphicButton)e.getSource();
			if(btn.getFILENAME().equals("SubmitBtn")){
				
				String CHARCTERNAME = null;
				Enumeration<AbstractButton> enums = topFrame.choiceChracterPanel.chracterGroup.getElements();
				while(enums.hasMoreElements()){
					 GraphicRadioButton radiobtn=(GraphicRadioButton)enums.nextElement(); 
					 if(radiobtn.isSelected())    
						 CHARCTERNAME=radiobtn.getFILENAME();
				}
			
			
				/*switch(CHARCTERNAME){
					case "MuziBtn": chracter="MUZI"; break;
					case "LyanBtn": chracter="LYAN"; break;
					case "ApeachBtn": chracter="APEACH"; break;
				}*/
				
				if(CHARCTERNAME.equals("MuziBtn"))
					chracter="MUZI"; 
				else if(CHARCTERNAME.equals("LyanBtn"))
					chracter="LYAN";
				else if(CHARCTERNAME.equals("ApeachBtn"))
					chracter="APEACH"; 
				
				try {
					writeUser();
					MainFrame.mf.startFrame.userListPa.readUser();							
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}				
			}
			
		
			
			JFrame topFrame=(JFrame)(SubmitPanel.this.getTopLevelAncestor());
			topFrame.dispose();
		}
		
		public void writeUser() throws IOException{				
			BufferedWriter out = new BufferedWriter(new FileWriter("resources/User.txt",true));
			String user=topFrame.userInputPanel.userInput.getText();				
		    out.write(chracter + "\t" + user);
		    out.newLine();			  
		    out.close();
		    
		    BasicDictionary basicDictionary= new BasicDictionary();
			basicDictionary.MAKE_UserDictionary(user);	
		}
		
		public void makeUserDictinary() throws IOException{
			
		}
		
	}	
				
}