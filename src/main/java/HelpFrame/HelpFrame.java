package HelpFrame;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.GlobalGraphic;
import Graphics.GraphicButton;
import Graphics.MainPoint;

public class HelpFrame extends JFrame{
	int numOfPage=7;
	ImageIcon image[]=new ImageIcon[numOfPage];
	
	Integer page;
	String fileName="help";	
	JLabel helpLa;
	
	public HelpFrame(){
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// 크기 고정
		setUndecorated(true);
		getContentPane().setBackground(GlobalGraphic.basic2);
		setVisible(true);
		setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 50, 50));
		setLocation(MainPoint.x-(this.getWidth()/2), MainPoint.y-(this.getHeight()/2));
	
		for(Integer page=0;page<numOfPage;page++)
			image[page]=new ImageIcon("images/HelpFrame/" +fileName + page.toString() + ".png");
		
		page=0;		
		helpLa=new JLabel(image[page]);
		
		ButtonPanel buttonPanel =new ButtonPanel();
		buttonPanel.setPreferredSize(new Dimension(750,70));
		add(helpLa,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		revalidate();
	}
	
	class ButtonPanel extends JPanel{
		GraphicButton leftBtn;
		GraphicButton rightBtn;
		GraphicButton confirmBtn;
		ButtonPanel(){
			
			this.setBackground(null);
			leftBtn=new GraphicButton("images/HelpFrame/","leftBtn",70,40);
			leftBtn.addActionListener(new ButtonActionListener());
			add(leftBtn);
			
			rightBtn=new GraphicButton("images/HelpFrame/","rightBtn",70,40);
			rightBtn.addActionListener(new ButtonActionListener());
			add(rightBtn);
			
			confirmBtn=new GraphicButton("images/HelpFrame/","confirmBtn",100,35);
			confirmBtn.addActionListener(new ButtonActionListener());
			add(confirmBtn);
			
		}		
		
		class ButtonActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				GraphicButton btn=(GraphicButton)e.getSource();
				switch(btn.getFILENAME()){
					case "leftBtn":
						if(page==numOfPage-1)rightBtn.setEnabled(true);
						page--;
						helpLa.setIcon(image[page]);
						if(page==0)leftBtn.setEnabled(false);
						ButtonPanel.this.repaint();
						break;
						
					case "rightBtn":
						if(page==0)leftBtn.setEnabled(true);
						page++;
						helpLa.setIcon(image[page]);
						if(page==numOfPage-1)rightBtn.setEnabled(false);
						ButtonPanel.this.repaint();
						break;
						
					case "confirmBtn":
						HelpFrame.this.dispose();
						break;
				}
			}
		}
	}
}
