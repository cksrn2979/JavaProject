package ScoreFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ScoreFrame extends JFrame {
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("파일");
	JMenu helpMenu=new JMenu("Help");
	
	public ScoreFrame(){
		setTitle("Score Menu");
		setSize(800,550);
		setVisible(true);
		setBackground(Color.WHITE);
		
		add(new NorthPanel(),BorderLayout.NORTH);
		add(new CenterPanel(),BorderLayout.CENTER);
		add(new SouthPanel(),BorderLayout.SOUTH);
		
		//파일 메뉴 생성
		fileMenu.add(new JMenuItem("새파일"));
		fileMenu.add(new JMenuItem("열기"));
		fileMenu.add(new JMenuItem("저장"));
		fileMenu.addSeparator();//구분선 추가
		fileMenu.add(new JMenuItem("종료"));
		
		//도움 메뉴 생성
		helpMenu.add(new JMenuItem("버전"));
		helpMenu.add(new JMenuItem("정보"));
		
		//메뉴를 메뉴바에 등록
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		//메뉴바 추가
		setJMenuBar(menuBar);

	}

}
