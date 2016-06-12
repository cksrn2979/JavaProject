package WordPlusFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Dictionary.UserDictionary;
import Graphics.GameFontB;
import Graphics.GameFontP;
import Graphics.GlobalGraphic;
import Graphics.GraphicButton;
import WordSetFrame.WordListPanel.WordListTable;
import WordSetFrame.WordSetFrame;

public class WordPlusFrame extends JFrame{
	InputPanel inputPanel;
	private WordListTable wordListTable;
	private String user;
	private JLabel topla;
	private JTextArea koreanInput;
	private JTextArea englishInput;
		
	public WordPlusFrame(WordListTable wordListTable, String user){
		this.user=user;
		this.wordListTable=wordListTable;
		
		setSize(400,350);
		setResizable(false);			
		setUndecorated(true);
		setVisible(true);	
		this.setShape(new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),100,100));
		getContentPane().setBackground(GlobalGraphic.basic);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);
			
		
		topla=new JLabel("Input Your Word");
		topla.setFont(new GameFontB(25));
		topla.setPreferredSize(new Dimension(400,70));
		topla.setHorizontalAlignment(SwingConstants.CENTER);
		topla.setVerticalAlignment(SwingConstants.CENTER);		
		this.add(topla,BorderLayout.NORTH);
		
		inputPanel = new InputPanel();
		inputPanel.setPreferredSize(new Dimension(400,210));
		add(inputPanel,BorderLayout.CENTER);
		
		SubmitPanel submitPanel = new SubmitPanel();
		submitPanel.setPreferredSize(new Dimension(400,70));	
		add(submitPanel,BorderLayout.SOUTH);
		
	}
	
	class InputPanel extends JPanel{
		InputPanel() {
			setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
			setBackground(null);
			
			koreanInput = new JTextArea();
			koreanInput.setPreferredSize(new Dimension(150,200));
			koreanInput.setText("한글");
			koreanInput.setFont(new GameFontP(15));
	
			englishInput = new JTextArea();
			englishInput.setPreferredSize(new Dimension(150,200));
			englishInput.setText("ENGLISH");
			englishInput.setFont(new GameFontP(15));
			
			add(koreanInput);
			add(englishInput);
			
		}
	}
	
	class SubmitPanel extends JPanel{
		GraphicButton submitBtn;
		GraphicButton concealBtn;
		
		SubmitPanel(){
			setBackground(null);
			makeBtn();

		}
		
		void makeBtn(){
			submitBtn=new GraphicButton("images/WordSetFrame/","SubmitBtn",100,35);
			submitBtn.addActionListener(new SubmitAction());
			
			concealBtn=new GraphicButton("images/WordSetFrame/","ConcealBtn",100,35);
			concealBtn.addActionListener(new SubmitAction());
			
			add(submitBtn);
			add(concealBtn);
		}
		
		class SubmitAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				GraphicButton btn=(GraphicButton)e.getSource();
				if(btn.getFILENAME().equals("SubmitBtn")){
					String korean[]=splite(koreanInput.getText());
					String english[]=splite(englishInput.getText());
					
					if(korean.length!=english.length){
						JOptionPane.showMessageDialog(WordPlusFrame.this, "단어 갯수가 달라요", "경고!",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					UserDictionary userDictionary=new UserDictionary(user);
					for(int i=0; i<korean.length;i++)
						userDictionary.add(korean[i],english[i],0);
					
					try {
						userDictionary.writeWordUserDictionary();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					wordListTable.loadDictionary(user);
					
					JOptionPane.showMessageDialog(WordPlusFrame.this, "단어가 추가되었습니다", "확인",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				else if (btn.getFILENAME()=="ConcealBtn");
				
				WordPlusFrame.this.dispose();
			}
			
			public String[] splite(String text){
				String[] spliter;				
				spliter= text.split("\n");				
				return spliter;				
			}
		}
		
	}
}
