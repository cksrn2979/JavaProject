package AllWordFrame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GameInterface.BasicInterface;
import GameInterface.MyDictionary;

//AllWordList 프레임
public class AllWordFrame extends JFrame{
	public AllWordFrame(){
		setTitle("All Word!!!");
		setSize(400,600);
		setVisible(true);
		setResizable(false);//크기 고정
		
		AllWordListTable allWordList =new AllWordListTable();
		
		//스크롤바 생성
		JScrollPane scroll=new JScrollPane(allWordList);
		
		add(scroll);
	}
	
	//AllWordList Table
	class AllWordListTable extends JTable{
		AllWordListTable(){
			
			//필드명 정의
			String[] header={"Korean", "English","SUCCESS"};
			
			//Table에 add할수 있도록 
			DefaultTableModel model= new DefaultTableModel(header,0);
			this.setModel(model);
			
			//WordList에 모든 단어 add
			for(int index=0; index<MyDictionary.getNumOfWord();index++){
				String content[]=new String[3];
				content[0]=MyDictionary.getWord(index);
				content[1]=MyDictionary.render(content[0]);
				content[2]=MyDictionary.getSuccess(content[0]).toString();
				model.addRow(content);
			}
		}
		
		//더블클릭수정불가
		public boolean isCellEditable(int i, int c){
	          return false;
		}
		
	}
	
	
}
