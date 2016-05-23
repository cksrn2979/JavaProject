package AllWordFrame;

import java.awt.Container;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import MainFrame.Interface;
import MyDictionary.MyDictionary;

//AllWordList 프레임
public class AllWordFrame extends JFrame{
	private Container c=this;
	
	public AllWordFrame(){
		setTitle("All Word!!!");
		setSize(400,600);
		setVisible(true);
		setResizable(false);//크기 고정
		
		AllWordListTable allWordList =new AllWordListTable();
		
		//스크롤바 생성
		JScrollPane scroll=new JScrollPane(allWordList);
		
		add(scroll);
		
		this.addWindowListener(new ExitListener());
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
			
			setCenter();
		}
		
		//더블클릭수정불가
		public boolean isCellEditable(int i, int c){
	          return false;
		}
		
		void setCenter(){
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
	
	class ExitListener implements WindowListener{
		 public void windowClosing(WindowEvent e){
			 Interface.setPlay(true);
			 ((Window) c).dispose();
		 }

		 public void windowOpened(WindowEvent e){}
		 public void windowActivated(WindowEvent e){}
		 public void windowDeactivated(WindowEvent e){}
		 public void windowClosed(WindowEvent e){}
		 public void windowIconified(WindowEvent e){}
		 public void windowDeiconified(WindowEvent e){}
	}	
}
