package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Item.Item1;
import Item.Item2;
import Item.Item3;
import Item.Item4;
import MyDictionary.MyDictionary;
import Thing.SuccessWord;

public class MainFrame extends JFrame{
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("파일");
	JMenu helpMenu=new JMenu("Help");
	
	MainFrame(){

		setTitle("Typing Trainer with English!");
		setSize(800,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);//크기 고정
		setBackground(Color.WHITE);
		
		//MyDictionay 초기화 - WORDLIST.txt모든 단어 입력
		try {MyDictionary.inWordFromFile();	} 
		catch (IOException e) {e.printStackTrace();}
		
		//SuccessWord 초기화
		SuccessWord.init();
		
		//Item 초기화
		Item1.setEnable(true);
		Item2.setEnable(false);
		Item3.setEnable(false);
		Item4.setEnable(false);

		
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
	
	public static void main(String[] args){
		MainFrame mf= new MainFrame();
		Container c = mf.getContentPane();
		
		EastPanel rp= new EastPanel();
		NorthPanel np= new NorthPanel();
		CenterPanel cp= new CenterPanel();
		SouthPanel sp= new SouthPanel();
		WestPanel wp= new WestPanel();
		
		c.add(rp,BorderLayout.EAST);
		c.add(np,BorderLayout.NORTH);
		c.add(cp,BorderLayout.CENTER);
		c.add(sp,BorderLayout.SOUTH);
		c.add(wp,BorderLayout.WEST);
	}
}
