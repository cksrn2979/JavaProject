package Thing;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MyDictionary.MyDictionary;

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
	
	public static void add(String korean, String english){
		String[] content=new String[2];
		content[0]=korean;
		content[1]=english;
		model.addRow(content);
		System.out.println(korean + " " + english);
		
		//단어 성공 횟수 증가
		MyDictionary.plusSuccess(korean);
	}
}
