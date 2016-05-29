package ScoreFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import Graphics.BtnGraphic;
import Graphics.BtnGraphicActionMainTain;
import Interface.GameColor;
import Interface.GameSet;

import ScoreFrame.FileIO;


class CenterPanel extends JPanel{
	CenterPanel(){
	
		add(new GradePanel(),BorderLayout.CENTER);
		setVisible(true);
		GradePanel gp=new GradePanel();
		add(gp,BorderLayout.CENTER);
	}
	
	class GradePanel extends JPanel{
		GradePanel(){
			setLayout(null);
			setBackground(null);
			
		}
		void makeLabel(){
			String path="C:/Users/Song/git/JavaProject/images/ScoreFrame/CenterPanel/";
			
			ImageIcon images[]=new ImageIcon[3];
			JLabel grade[]=new JLabel[3];
			
			for(int i=0;i<3;i++)
				{
				images[i]=new ImageIcon(path+"고양이얼굴.png");
				grade[i]=new JLabel(i+"등",images[0],JLabel.CENTER);
				grade[i].setHorizontalTextPosition(SwingConstants.CENTER);
				grade[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				}
			
			for(int i=0; i<5; i++){
				grade[i].setLocation(330, 280+(i*40));
				add(grade[i]);
			}	
		
		
		}
	}
}

	
	

