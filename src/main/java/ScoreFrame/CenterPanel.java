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
		setBackground(Color.gray);
		setLayout(null);
		setPreferredSize(new Dimension(500,420));
		
		//CenterPanel 에서 함수호출 테스트 
		Integer i=new Integer(ScorePanel.sp.fIO.getScore("s"));
		JButton a=new JButton(i.toString());
		a.setSize(100,100);
		a.setLocation(100,100);
		add(a);
		
		
	}
}

	
	

