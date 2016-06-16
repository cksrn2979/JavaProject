package RankFrame;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Graphics.GameFontB;
import Graphics.GameFontP;
import Graphics.GlobalGraphic;
import Graphics.GraphicPanel;
import PlayPanel.PlayPanel;

class CenterPanel extends JPanel {
	String path = "images/RankFrame/";
	String myUser;
	String myCharacter;
	Integer myScore;
	Integer myLevel;
	RankerArray rankers;
	
	CenterPanel(PlayPanel playPanel) {
		this.myUser=playPanel.startInfo.getUser();
		this.myCharacter=playPanel.startInfo.getCharacter();
		this.myScore=playPanel.play.getScore();
		this.myLevel=playPanel.play.getLevel();
		rankers = new RankerArray();
	
		setVisible(true);
		setBackground(null);
		setLayout(null);
		setPreferredSize(new Dimension(600, 460));

		GradePanel gradePanel = new GradePanel(path, "GradePanel", 250, 320);
		gradePanel.setLocation(20, 20);
		
		MyGradePanel myGradePanel = new MyGradePanel(path, "myScore", 250, 200);
		myGradePanel.setLocation(300, 20);		
		
		ChracterPanel chracterPanel= new ChracterPanel(path, "CharacterPanel", 100, 100);
		chracterPanel.setLocation(450,220);
		
		GraphicPanel userPanel =new GraphicPanel(path, "UserPanel", 130, 30);
		JLabel userla =new JLabel(myUser);
		userla.setHorizontalAlignment(SwingConstants.RIGHT);
		userPanel.add(userla);
		userPanel.setLocation(300,235);
		
		GraphicPanel levelPanel =new GraphicPanel(path, "LevelPanel", 130, 30);
		JLabel levella =new JLabel(myLevel.toString());
		levella.setHorizontalAlignment(SwingConstants.RIGHT);
		levelPanel.add(levella);
		levelPanel.setLocation(300,275);
		
		add(gradePanel);
		add(myGradePanel);
		add(chracterPanel);
		add(userPanel);
		add(levelPanel);
		
	}
	
	
	class ChracterPanel extends GraphicPanel{
		public ChracterPanel(String path, String FILENAME, int width, int height) {
			super(path, FILENAME, width, height);
			this.setLayout(null);
			ImageIcon myChimage = new ImageIcon(path + myCharacter + "_Score.gif");
			JLabel myChLabel = new JLabel(myChimage);
			
			myChLabel.setSize(70,70);
			myChLabel.setLocation((width-70)/2,(height-70)/2);
			add(myChLabel);
		}
		
	}
	class GradePanel extends GraphicPanel {
		
		

		public GradePanel(String path, String FILENAME, int width, int height) {
			super(path, FILENAME, width, height);
			
			int numOfRankers;
			if(rankers.size()<5)
				numOfRankers=rankers.size();
			else numOfRankers=5;
			
			setLayout(null);
			setGrade(numOfRankers);			
		}

		void setGrade(int numOfRankers) {

			ImageIcon images[] = new ImageIcon[numOfRankers];
			ImageIcon gradeImg[] = new ImageIcon[numOfRankers];

			JLabel faceLabel[] = new JLabel[numOfRankers];
			JLabel scores[] = new JLabel[numOfRankers];
			JLabel gradeLabel[] = new JLabel[numOfRankers];
			JLabel nameLabel[] = new JLabel[numOfRankers];

			String name = " ";// 이름 저장
			String faceType = " ";// 캐릭터 타입 저장

			for (int i = 0; i < numOfRankers; i++) {

				gradeImg[i] = new ImageIcon(path + "trophy.png");
				gradeLabel[i] = new JLabel(gradeImg[i]);

				name = rankers.get(i).getName();

				faceType = rankers.get(i).getCharacter();
				images[i] = new ImageIcon(path + faceType + "Face.png");
				
				faceLabel[i] = new JLabel(images[i]);

				int width=60;
				int height=60;
				int vGap=60;
				scores[i] = new JLabel(rankers.get(i).getScore().toString());
				scores[i].setSize(width, height);
				scores[i].setLocation(200, i * vGap);
				scores[i].setFont(new GameFontB(15));

				faceLabel[i].setSize(width, height);
				faceLabel[i].setLocation(10, i * vGap);

				gradeLabel[i].setSize(width, height);
				gradeLabel[i].setLocation(60, i * vGap);

				nameLabel[i] = new JLabel(name);
				nameLabel[i].setSize(width, height);
				nameLabel[i].setLocation(110, i * vGap);
				nameLabel[i].setFont(new GameFontB(12));

				add(faceLabel[i]);
				add(gradeLabel[i]);
				add(scores[i]);
				add(nameLabel[i]);
			}
		}
	}

	class MyGradePanel extends GraphicPanel {

		MyGradePanel(String path, String FILENAME, int width, int height) {
			super(path, FILENAME, width, height);
			
			JLabel myScoreLabel = new JLabel(myScore.toString());		
			myScoreLabel.setSize(250, 200);
			myScoreLabel.setForeground(GlobalGraphic.character);
			myScoreLabel.setFont(new GameFontP(120));
			
			add(myScoreLabel);
		}
	}
}
