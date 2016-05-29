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
		setVisible(true);
		setBackground(Interface.GameColor.muzi);
		setLayout(null);
		setPreferredSize(new Dimension(500,420));
		
		String path="C:/Users/Song/git/JavaProject/images/ScoreFrame/CenterPanel/";
		
		int num=3;//전체 화면에 표시할 등수 갯수
		
		ImageIcon images[]=new ImageIcon[num];
		ImageIcon gradeImg []=new ImageIcon[num];
		
		JLabel faceLabel[]=new JLabel[num];
		JLabel scores[]=new JLabel[num];
		JLabel gradeLabel[]=new JLabel[num];
		JLabel nameLabel[]=new JLabel[num];
		
		String name="0";
	
			images[0]=new ImageIcon(path+"피치얼굴.png");	
			images[1]=new ImageIcon(path+"무지얼굴.png");	
			images[2]=new ImageIcon(path+"라이언얼굴.png");	
			
			for(int i=0;i<num;i++){
			
			
			gradeImg[i]=new ImageIcon(path+"등수.png");
					
			faceLabel[i]=new JLabel(images[i]);
			gradeLabel[i]=new JLabel(gradeImg[i]);
			
			name=ScorePanel.sp.fIO.getGradeName(i);
			
			nameLabel[i]=new JLabel(name);
			scores[i]=new JLabel(ScorePanel.sp.fIO.getScore(name).toString());

			faceLabel[i].setSize(100,100);
			faceLabel[i].setLocation(100,100+i*100);
			
			gradeLabel[i].setSize(100,100);
			gradeLabel[i].setLocation(200,100+i*100);
			
			nameLabel[i].setSize(100,100);
			nameLabel[i].setLocation(300, 100+i*100);
			
			scores[i].setSize(100,100);
			scores[i].setLocation(350, 100+i*100);
		
			add(faceLabel[i]);
			add(gradeLabel[i]);
			add(scores[i]);
			add(nameLabel[i]);
		}
		
		
		
		
	
	
	
	}
}

	
	

