package WordSetFrame;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Dictionary.UserDictionary;

public class WordListPanel extends JPanel {
	WordListPanel() {
		setBackground(null);
		setPreferredSize(new Dimension(300, 350));
		JScrollPane scroll = new JScrollPane(new WordListTable());
		
		scroll.setPreferredSize(new Dimension(250, 300));
		scroll.setAlignmentX(CENTER_ALIGNMENT);

		add(scroll);
	}

	class WordListTable extends JTable {
		WordListTable() {

			// 필드명 정의
			String[] header = { "Korean", "English", "SUCCESS" };

			// Table에 add할수 있도록
			DefaultTableModel model = new DefaultTableModel(header, 0);
			this.setModel(model);

			// WordList에 모든 단어 add
			for (int index = 0; index < UserDictionary.getNumOfWord(); index++) {
				String content[] = new String[3];
				content[0] = UserDictionary.getWord(index);
				content[1] = UserDictionary.render(content[0]);
				content[2] = UserDictionary.getSuccess(content[0]).toString();
				model.addRow(content);
			}

			setCenter();
		}

		// 더블클릭수정불가
		public boolean isCellEditable(int i, int c) {
			return false;
		}

		void setCenter() {
			// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

			// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

			// 정렬할 테이블의 ColumnModel을 가져옴
			TableColumnModel tcmSchedule = getColumnModel();

			// 반복문을 이용하여 테이블을 가운데 정렬로 지정
			for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
				tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
			}
		}
	}
}
