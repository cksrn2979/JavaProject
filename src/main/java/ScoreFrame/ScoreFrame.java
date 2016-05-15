package ScoreFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class ScoreFrame extends JFrame {
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("파일");
	JMenu helpMenu=new JMenu("Help");
	
	public ScoreFrame(){
		Container c = getContentPane();
		setTitle("Score Menu");
		setSize(800,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.WHITE);
		
		CenterPanel cp=new CenterPanel();
		NorthPanel np=new NorthPanel();
		SouthPanel sp=new SouthPanel();
		
		c.add(cp,BorderLayout.CENTER);
		c.add(np,BorderLayout.NORTH);
		c.add(sp,BorderLayout.SOUTH);
		
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
