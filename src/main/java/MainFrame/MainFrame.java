package MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Graphics.BtnGraphic;
import Graphics.BtnGraphicAction;
import Graphics.GraphicForm;
import Interface.GameColor;
import MakeUserFrame.MakeUserFrame;
import PlayPanel.PlayPanel;
import StartFrame.StartFrame;


public class MainFrame extends JFrame{
	public static MainFrame mf;
	public MainPagePanel mainPa;
	public PlayPanel playPa;
	public StartFrame startFra;
	public MakeUserFrame makeUserFra;
	
	
	MainFrame(){
		setSize(800,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);//크기 고정
		setUndecorated(true);
		setVisible(true);
		
		//com.sun.awt.AWTutilities.setWindowShape(this,new RoundRectangle2D.Float(0,0,this.getWidth(),this.getHeight(),20,20));
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setLocation((windowSize.width - frameSize.width) / 2,
				(windowSize.height - frameSize.height) / 2);
		
		mainPa=new MainPagePanel();
		this.setContentPane(mainPa);
		
		
		createMenuBar();
		
	}
	
	void createMenuBar(){
		
		JMenuBar menuBar=new JMenuBar();
		JMenu fileMenu=new JMenu("File");
		JMenu helpMenu=new JMenu("Help");
		JMenuItem regame=new JMenuItem("Regame");
		JMenuItem exit=new JMenuItem("exit");
		JMenuItem version=new JMenuItem("Version");
		JMenuItem developer=new JMenuItem("Developer");
		
		menuBar.setPreferredSize(new Dimension(800,30));
		menuBar.setBackground(Color.LIGHT_GRAY);
		//파일 메뉴 생성
		fileMenu.add(regame);
	
		fileMenu.addSeparator();//구분선 추가
		fileMenu.add(exit);
						
		//파일 메뉴 단축키 설정
		regame.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
		
		//add Listener
		version.addActionListener(new HelpActionListener());
		developer.addActionListener(new HelpActionListener());
						
		//도움 메뉴 생성
		helpMenu.add(version);
		helpMenu.add(developer);
				
		//메뉴를 메뉴바에 등록
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
				
		//메뉴바 추가
		setJMenuBar(menuBar);
	}
	
	class HelpActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item= (JMenuItem) e.getSource();
			String s=item.getText();
			if(s.equals("Version"))
				JOptionPane.showMessageDialog(null, "version. 1.00\n2016.05.23","Version",JOptionPane.INFORMATION_MESSAGE);
			else if(s.equals("Developer"))
				JOptionPane.showMessageDialog(null, "Hansung.Univ\nComputer Engneering\n\nLee Changoo / Seo Songi","Developer",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	class MainPagePanel extends JPanel{
			MainPagePanel(){
			setLayout(null);
			MakeButton();
		}
		
		void MakeButton(){
			String path="images/MainFrame/MainPage";
			
			BtnGraphic btn[] = new BtnGraphic[5];
			btn[0]=new BtnGraphic(path+"/menubtn", "Start",100,35);
			btn[1]=new BtnGraphic(path+"/menubtn", "MakeUser",100,40);
			btn[2]=new BtnGraphic(path+"/menubtn", "WordSet",100,40);
			btn[3]=new BtnGraphic(path+"/menubtn", "Help",100,40);
			btn[4]=new BtnGraphic(path+"/menubtn", "Exit",100,40);
			
			btn[0].addla("게임 시작",15);
			btn[1].addla("유저 생성",15);
			btn[2].addla("단어 셋팅",15);
			btn[3].addla("게임 방법",15);
			btn[4].addla("종료",15);
		
			
			BtnGraphicAction action =new MenuAction();
			for(int i=0; i<5; i++)
				btn[i].addMouseListener(action);	
			
			for(int i=0; i<5; i++){
				btn[i].setLocation(330, 280+(i*40));
				add(btn[i]);
			}		
		}
				
		class MenuAction extends  BtnGraphicAction {
			public void clickAct(BtnGraphic btn) {
				if(btn.getID().equals("Start"))
					startFra=new StartFrame();
				else if(btn.getID().equals("MakeUser"))
					makeUserFra=new MakeUserFrame(); 
//				else if(btn.equals("WordSet"));
//				else if(btn.equals("Help"))
//					;
				else if(btn.getID().equals("Exit"))
					 System.exit(0);
				
//				switch(btn.getID()){
//				case "Start": startFra=new StartFrame(); break;
//				case "MakeUser": makeUserFra=new MakeUserFrame(); break;
//				case "WordSet": break;
//				case "Help": break;
//				case "Exit": System.exit(0);break; 
//				}
			}
		}
				
		
		public void paintComponent(Graphics g) {
			ImageIcon background = new ImageIcon("images/MainFrame/MainPage/Background.png");	
			g.drawImage(background.getImage(), 0, 0, null);	
			setOpaque(false);
			super.paintComponent(g);
		}	
	}		
	
	public static void main(String[] args){
		mf =new MainFrame();
	}
}
