package PlayPanel.EastPanel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Graphics.GraphicForm;
import Interface.GameFontB;
import Interface.GameSet;

class InformationPanel extends JPanel{
	InformationPanel(){
		setBackground(null);
		setLayout(null);
		setPreferredSize(new Dimension(130,180));
			
		JLabel la=new JLabel("User : " + GameSet.getUser());
		la.setFont(new GameFontB(15));
		la.setSize(200,20);
		la.setLocation(20,10);	
		add(la);		
		
		
		String path="images/MainFrame/"+GameSet.getCharacter()+"/PlayPanel/EastPanel/InformaitonPanel/face";
		CharacterFaceGraphic faceGra=new CharacterFaceGraphic(path,"faceGra",120,160);
		faceGra.setLocation(10,40);
		add(faceGra);
	}
	
	class CharacterFaceGraphic extends GraphicForm{
		public CharacterFaceGraphic(String path, String btnID, int width, int height) {
			super(path, btnID, width, height);
			// TODO Auto-generated constructor stub
		}
		
	}
}