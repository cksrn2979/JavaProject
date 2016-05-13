package TypeTrainerScore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

class ScoreListPanel extends JPanel {
	ScoreListPanel(){
		setBackground(null);
	
		String menu[]={"순위","LEVEL"," ","SCORE","SPEED"};
		String list[][]={
				{"1","20",".....","100","0.44"},{"2","18",".....","80","0.3"},
				{"3","10",".....","40","0.1"},{"4","8",".....","30","0.1"}
		};
	
		 
		JTable scoreList= new JTable(list,menu);
		JScrollPane scroll=new JScrollPane(scoreList);
		scroll.setPreferredSize(new Dimension(500,350));
		
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		 
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = scoreList.getColumnModel();
		 
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		add(scroll);	
		
		}
}
class InformPanel extends JPanel{
	InformPanel(){
		setBackground(null);
		JLabel name=new JLabel("User : 서송이");
		JLabel result=new JLabel("Final Level : 20");
		Font font = new Font("나눔 고딕",Font.BOLD,13);
		name.setFont(font);
		result.setFont(font);
		
		add(name);
		add(result);
	}
}

class CenterPanel extends JPanel{
	CenterPanel(){
		setBackground(Color.white);
		Border CenterBorder= BorderFactory.createEtchedBorder();
		setBorder(CenterBorder);
		setLayout(new BorderLayout());
		
		add(new InformPanel(),BorderLayout.NORTH);
		add(new ScoreListPanel(),BorderLayout.CENTER);
		
	}	
}
