package MainFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import AllWordFrame.AllWordFrame;

class InformationPanel extends JPanel{
	InformationPanel(){
		setBackground(null);
		setPreferredSize(new Dimension(0,60));
		
		Border infomationBorder= BorderFactory.createEtchedBorder();
		infomationBorder=BorderFactory.createTitledBorder("INFORMATION");
		setBorder(infomationBorder);
		
		Font font = new Font("나눔 고딕",Font.BOLD,13);
		JLabel la1=new JLabel("TRY - 20");
		JLabel la2=new JLabel("User : 서송이");
		la1.setFont(font);
		la2.setFont(font);
		add(la1);
		add(la2);		
	}
}

class SuccessWordPanel extends JPanel{
	static SuccessWordList successWordList;
	
	SuccessWordPanel(){
		Border ListBorder= BorderFactory.createEtchedBorder();
		ListBorder=BorderFactory.createTitledBorder("Success Word");
		setBorder(ListBorder);
		setBackground(null);	
		
		successWordList=new SuccessWordList();
		JScrollPane scroll=new JScrollPane(successWordList);
		scroll.setPreferredSize(new Dimension(130,220));
		
		add(scroll);
	}
	
	class SuccessWordList extends JTable{
		DefaultTableModel model;
		
		SuccessWordList(){
			String[] header={"Korean","English"};
			model= new DefaultTableModel(header,0);
		
			this.setModel(model);
			}
		
		//더블클릭수정불가
		public boolean isCellEditable(int i, int c){
	          return false;
	         }
		
		void addSuccessWord(String korean, String english){
			String[] content=new String[2];
			content[0]=korean;
			content[1]=english;
			model.addRow(content);
		}
	}
	
}

class WordSetPanel extends JPanel{
	WordSetPanel(){
		
		setBackground(null);
		Border WordSetBorder= BorderFactory.createEtchedBorder();
		WordSetBorder=BorderFactory.createTitledBorder("WordSet");
		
		setBorder(WordSetBorder);
		JButton allWordbtn=new JButton("All Word");
		allWordbtn.addMouseListener(new AllWordMouseListener());
		add(allWordbtn,BorderLayout.CENTER);
		add(new Button("+"),BorderLayout.EAST);
	}
	
	class AllWordMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			new AllWordFrame();
		}
		
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
	}
}


public class EastPanel extends JPanel{
	EastPanel(){
		setBackground(new Color(240,240,255));
		setPreferredSize(new Dimension(150,0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		InformationPanel info=new InformationPanel();
		add(info);
		
		SuccessWordPanel successWord=new SuccessWordPanel();
		add(successWord);
		
		WordSetPanel wordSet=new WordSetPanel();
		add(wordSet);	

	}
}
