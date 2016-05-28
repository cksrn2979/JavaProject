package MakeUserFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Graphics.BtnGraphic;
import Graphics.BtnGraphicAction;
import Graphics.BtnGraphicActionMainTain;
import Graphics.GraphicForm;
import Interface.GameColor;

public class MakeUserFrame extends JFrame{
	JTextField userInput;
	String character;
	Window f=this;
	
	public MakeUserFrame(){
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		setVisible(true);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);

	
		setLayout(new BorderLayout());
			
		add(new ChoiceCharacterPanel(),BorderLayout.NORTH);
		add(new UserInputPanel(),BorderLayout.CENTER);
		add(new submitPanel(),BorderLayout.SOUTH);
	}
		
	class ChoiceCharacterPanel extends JPanel{
		JLabel choicela;
		BtnGraphic[] choiceBtn;
			
		ChoiceCharacterPanel(){
			this.setPreferredSize(new Dimension(200,200));
			setLayout(null);
			setBackground(GameColor.frame1);
				
						
			makeBtn();
				
		}
			
		void makeBtn(){
			String path="images/MakeUserFrame/ChoiceCharacter/";
			choiceBtn=new BtnGraphic[3];
			choiceBtn[0] =new BtnGraphic(path+"/muziBtn","Muzi",100,100);
			choiceBtn[1] =new BtnGraphic(path+"/LionBtn","Lyan",100,100);
			choiceBtn[2] =new BtnGraphic(path+"/ApeachBtn","Apeach",100,100);
			
			CharacterAction action = new CharacterAction();
			choiceBtn[0].addMouseListener(action);
			choiceBtn[1].addMouseListener(action);
			choiceBtn[2].addMouseListener(action);
			
			for(int i=0; i<3; i++){
				choiceBtn[i].setLocation(30+(i*110),50);
				add(choiceBtn[i]);
			}
		}
			
		class CharacterAction extends BtnGraphicActionMainTain{
			public void clickAct(BtnGraphic btn) {
				character=this.getChoice();
			}			
		}
	}
		
	class UserInputPanel extends JPanel{
		UserInputPanel(){
			setPreferredSize(new Dimension(400,10));
			setLayout(new FlowLayout());
			setBackground(GameColor.frame1);				
			userInput= new JTextField("",15);
			add(userInput);
		}
	}
	
	class submitPanel extends JPanel{
		BtnGraphic[] submitBtn;
			
		submitPanel(){
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
				if(btn.getID()=="submit")
					try {
						writeUser();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				else;
				f.dispose();
			}
			
			public void writeUser() throws IOException{				
				BufferedWriter out = new BufferedWriter(new FileWriter("C:/Workspace/JavaProject/resources/User.txt",true));
				String user=userInput.getText();				
			    out.write(character + "\t" + user);
			    out.newLine();			  
			    out.close();
			}
		
		}
	}			
}
