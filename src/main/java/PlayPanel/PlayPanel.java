package PlayPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Interface.GameSet;
import MyDictionary.MyDictionary;
import PlayPanel.CenterPanel.CenterPanel;
import PlayPanel.EastPanel.EastPanel;
import PlayPanel.NorthPanel.NorthPanel;
import PlayPanel.SouthPanel.SouthPanel;
import PlayPanel.WestPanel.WestPanel;

public class PlayPanel extends JPanel{

	public EastPanel ep;
	public NorthPanel np;
	public CenterPanel cp;
	public SouthPanel sp;
	public WestPanel wp;
	
	
	public PlayPanel(){	
	
		//MyDictionay 초기화 - WORDLIST.txt모든 단어 입력
		try {MyDictionary.readWordFromFile();	} 
		catch (IOException e) {e.printStackTrace();}
	
		setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		String npPath=GameSet.getPath()+"NorthPanel/";
		String cpPath=GameSet.getPath()+"CenterPanel/";	
		wp= new WestPanel();
		sp= new SouthPanel();
		ep= new EastPanel();
		np= new NorthPanel(npPath,"background",800,60);
		cp= new CenterPanel(cpPath,"background",500,420);

			
		add(sp,BorderLayout.SOUTH);
		add(ep,BorderLayout.EAST);
		add(np,BorderLayout.NORTH);
		add(cp,BorderLayout.CENTER);		
		add(wp,BorderLayout.WEST);
		
	}
}
	
	
	/*
	class ExitListener implements WindowListener{
		 public void windowClosing(WindowEvent e){
			 try {	MyDictionary.writeWordFromFile();} 
			 catch (IOException e1) {e1.printStackTrace();}
			
			 System.exit(0);
		 }

		 public void windowOpened(WindowEvent e){}
		 public void windowActivated(WindowEvent e){}
		 public void windowDeactivated(WindowEvent e){}
		 public void windowClosed(WindowEvent e){}
		 public void windowIconified(WindowEvent e){}
		 public void windowDeiconified(WindowEvent e){}
	}
}
*/
