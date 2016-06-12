package WordSetFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Dictionary.UserDictionary;
import Graphics.GraphicButton;
import WordPlusFrame.WordPlusFrame;
import WordSetFrame.WordListPanel.WordListTable;

public class SetButtonPanel extends JPanel {
	GraphicButton wordPlusbtn;
	GraphicButton successResetbtn;

	SetButtonPanel() {
		setBackground(null);
		makeBtn();
	}

	void makeBtn() {

		wordPlusbtn = new GraphicButton("images/WordSetFrame/", "wordPlusBtn", 100, 40);
		wordPlusbtn.addActionListener(new SetButtonAction());
		
		successResetbtn = new GraphicButton("images/WordSetFrame/", "SuccessResetBtn", 100, 40);
		successResetbtn.addActionListener(new SetButtonAction());

		
		add(wordPlusbtn);
		add(successResetbtn);
	}

	class SetButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			WordSetFrame topFrame=(WordSetFrame)(SetButtonPanel.this.getTopLevelAncestor());
			String selection=(String)topFrame.userListPanel.getSelectedItem();
			
			if(selection==null){
				JOptionPane.showMessageDialog(topFrame,"유저를 선택해주세요","경고!",JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String spliter[]=selection.split("\t");			
			String user=spliter[1];			
			
			GraphicButton btn = (GraphicButton) e.getSource();
			if (btn.getFILENAME().equals("wordPlusBtn"))
				new WordPlusFrame(topFrame.wordListPanel.wordListTable,user);
			else if (btn.getFILENAME().equals("SuccessResetBtn"))
				successReset(topFrame.wordListPanel.wordListTable,user);
		}
		
		private void successReset(WordListTable wordListTable, String user){
			UserDictionary userDictionary =new UserDictionary(user);
			userDictionary.successReset();
			try {
				userDictionary.writeWordUserDictionary();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wordListTable.loadDictionary(user);
		}
	}
}
