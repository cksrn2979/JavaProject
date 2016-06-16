package MainFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import Graphics.MainPoint;
import PlayPanel.PlayPanel;
import Sounds.Player;
import StartFrame.StartFrame;


public class MainFrame extends JFrame {
	public MainPagePanel mainPanel;
	public PlayPanel playPanel;
	public StartFrame startFrame;
	private Point mouseClickedLocation = new Point(0, 0);
	
	public MainFrame() {
		
		setResizable(false);// 크기 고정
		setUndecorated(true);
		setVisible(true);
		this.setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 30, 30));
		setSize(800, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
		MainPoint.x=(MainFrame.this.getWidth()/2) + (this.getLocationOnScreen().x -  MainFrame.this.mouseClickedLocation.x);
		MainPoint.y=(MainFrame.this.getHeight()/2) + (this.getLocationOnScreen().y -  MainFrame.this.mouseClickedLocation.y);
    
		
		this.addMouseListener(new FrameMove_mouseAdapter());
		this.addMouseMotionListener(new FrameMove_mouseMotionAdapter());	
		
		
		mainPanel = new MainPagePanel();
		this.setContentPane(mainPanel);
		
		Thread bgmTh=new Thread(){
			public void run(){
				while(true){
					Player.playSound("bgm");
					try{
						sleep(1000*130);
					}catch(InterruptedException e){
						return;
					}
				}
			}
		};
		
		bgmTh.start();
		
		createMenuBar();		
		revalidate();

	}
	
	class FrameMove_mouseAdapter extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	        MainFrame.this.mouseClickedLocation.x = e.getX();
	        MainFrame.this.mouseClickedLocation.y = e.getY();
	    }
	}
	
	class FrameMove_mouseMotionAdapter extends MouseMotionAdapter {
		public void mouseMove(MouseEvent e) {}	    
	    public void mouseDragged(MouseEvent e) {
	    	MainFrame.this.setLocation(e.getLocationOnScreen().x -  MainFrame.this.mouseClickedLocation.x,
	    			 e.getLocationOnScreen().y -  MainFrame.this.mouseClickedLocation.y);
	    	
	        MainPoint.x=(MainFrame.this.getWidth()/2) + (e.getLocationOnScreen().x -  MainFrame.this.mouseClickedLocation.x);
	        MainPoint.y=(MainFrame.this.getHeight()/2) + (e.getLocationOnScreen().y -  MainFrame.this.mouseClickedLocation.y);
	    }
	}
	
	void createMenuBar() {

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem exit = new JMenuItem("exit");
		JMenuItem version = new JMenuItem("Version");
		JMenuItem developer = new JMenuItem("Developer");

		menuBar.setPreferredSize(new Dimension(800, 30));
		
		// 파일 메뉴 생성	
		fileMenu.add(exit);

		// 파일 메뉴 단축키 설정
		exit.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_MASK));

		// add Listener
		version.addActionListener(new MenuActionListener());
		developer.addActionListener(new MenuActionListener());
		exit.addActionListener(new MenuActionListener());
		
		// 도움 메뉴 생성
		helpMenu.add(version);
		helpMenu.add(developer);

		// 메뉴를 메뉴바에 등록
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// 메뉴바 추가
		setJMenuBar(menuBar);
	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			switch(cmd){
			case "Version":
				JOptionPane.showMessageDialog(null, "version. 1.00\n2016.06.16", "Version",JOptionPane.INFORMATION_MESSAGE);
				break;				
			case "Developer" :
				JOptionPane.showMessageDialog(null, "Hansung.Univ\nComputer Engneering\n\nLee Changoo / Seo Songi","Developer",
												JOptionPane.INFORMATION_MESSAGE);
				break;				
			case "exit":
				System.exit(0);
				break;
			}
		}
	}



	public static void main(String[] args) {
		
		System.setProperty("file.encoding", "UTF-8");
		Field charset;
		try {
			charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null, null);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new MainFrame();
	}
}
