package GameInterface;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SuccessWord {
	private static DefaultTableModel model;
	private static JTable table;
	
	public static void init(){	
		String[] header={"Korean","English"};
		model= new DefaultTableModel(header,0);
		table=new JTable(model);
	}
		
	public static JTable getTable(){
		return table;
	}
	
	//테이블에 행 추가
	public static void add(String korean, String english){
		String[] content=new String[2];
		content[0]=korean;
		content[1]=english;
		model.insertRow(0, content);
		
	}
}
