package AllWordFrame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Thing.WordList;

public class AllWordFrame extends JFrame{
	
	public AllWordFrame(){
		setTitle("All Word!!!");
		setSize(400,600);
		setVisible(true);
		setResizable(false);//크기 고정
		
		AllWordList allWordList =new AllWordList();
		JScrollPane scroll=new JScrollPane(allWordList);
		
		add(scroll);
	}
	
	class AllWordList extends JTable{
		
		AllWordList(){
			String[] header={"Korean", "English","SUCCESS"};
			DefaultTableModel model= new DefaultTableModel(header,0);
			this.setModel(model);
			
			for(int i=0; i<WordList.wordList.size();i++){
				String content[]=new String[3];
				content[0]=WordList.wordList.get(i);
				content[1]=WordList.render(content[0]);
				content[2]=WordList.getSuccess(content[0]).toString();
				model.addRow(content);
			}
		}
		
		//더블클릭수정불가
		public boolean isCellEditable(int i, int c){
	          return false;
		}
		
		
	}
	
	
}
