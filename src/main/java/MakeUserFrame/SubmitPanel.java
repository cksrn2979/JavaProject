package MakeUserFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Dictionary.BasicDictionary;
import Dictionary.UserDictionary;
import Graphics.GraphicButton;
import Graphics.GraphicRadioButton;
import MainFrame.MainFrame;
import StartFrame.StartFrame;

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
				
				if(CHARCTERNAME==null){
					JOptionPane.showMessageDialog(null, "캐릭터를 선택해주세요", "경고!",JOptionPane.WARNING_MESSAGE);
					return;
				}
			
			
				switch(CHARCTERNAME){
					case "MuziBtn": chracter="MUZI"; break;
					case "LyanBtn": chracter="LYAN"; break;
					case "ApeachBtn": chracter="APEACH"; break;
				}			

				String user = topFrame.userInputPanel.userInput.getText();
				if (user.equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "경고!", JOptionPane.WARNING_MESSAGE);
					return;

				}
				
				MakeUserFrame makeuserFrame=(MakeUserFrame)SubmitPanel.this.getTopLevelAncestor();
				StartFrame startFrame=makeuserFrame.startFrame;

				try {
					writeUser(user);
					startFrame.userListPa.readUser();
					BasicDictionary basicDictionary = new BasicDictionary();
					basicDictionary.MAKE_UserDictionary(user);
					UserDictionary u= new UserDictionary(user);
					System.out.println(u.getWord(0));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			
		
			
			JFrame topFrame=(JFrame)(SubmitPanel.this.getTopLevelAncestor());
			topFrame.dispose();
		}
		
		public void writeUser(String user) throws IOException{				
			BufferedWriter out = new BufferedWriter(new FileWriter("resources/User.txt",true));							
		    out.write(chracter + "\t" + user);
		    out.newLine();			  
		    out.close();		   
		}
		
		public void makeUserDictinary() throws IOException{
			
		}
		
	}	
				
}