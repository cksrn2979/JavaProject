package WordSetFrame;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dictionary.UserDictionary;
import Graphics.GameFontP;

public class WordListPanel extends JPanel {
	WordListTable wordListTable;
	WordListPanel() {
		setBackground(null);
		JScrollPane scroll = new JScrollPane(wordListTable=new WordListTable());
		
		scroll.setPreferredSize(new Dimension(230, 300));
		scroll.setAlignmentX(CENTER_ALIGNMENT);

		add(scroll);
	}

	class WordListTable extends JTable {
		DefaultTableModel model;
		String[] header = { "한글", "영어", "성공횟수" };
		WordListTable() {
			this.setFont(new GameFontP(13));
			// Table에 add할수 있도록
			model = new DefaultTableModel(header, 0);
			this.setModel(model);
		}

		// 더블클릭수정불가
		public boolean isCellEditable(int i, int c) {
			return false;
		}
		
		public void loadDictionary(String user){
			model = new DefaultTableModel(header, 0);
			this.setModel(model);
		
			UserDictionary dictionary= new UserDictionary(user);
			// WordList에 모든 단어 add
			for (int index = 0; index < dictionary.getNumOfWord(); index++) {
				String content[] = new String[3];
				content[0] = dictionary.getWord(index);
				content[1] = dictionary.render(content[0]);
				content[2] = dictionary.getSuccess(content[0]).toString();
				model.insertRow(0, content);
			}
			
		}
	}
}
