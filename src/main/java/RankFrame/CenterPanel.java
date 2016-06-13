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

class CenterPanel extends JPanel {
	String path = "images/ScoreFrame/";
	String myUser;
	String myCharacter;
	Integer myScore;
	Integer myLevel;
	RankerArray rankers;
	
	CenterPanel(String user, String character, Integer score, Integer level) {
		this.myUser=user;
		this.myCharacter=character;
		this.myScore=score;
		this.myLevel=level;
		rankers = new RankerArray();
	
		setVisible(true);
		setBackground(GlobalGraphic.character);
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

		int num = 5;// 전체 화면에 표시할 등수 표시 갯수

		public GradePanel(String path, String FILENAME, int width, int height) {
			super(path, FILENAME, width, height);

			setLayout(null);
			setGrade();			
		}

		void setGrade() {

			ImageIcon images[] = new ImageIcon[num];
			ImageIcon gradeImg[] = new ImageIcon[num];

			JLabel faceLabel[] = new JLabel[num];
			JLabel scores[] = new JLabel[num];
			JLabel gradeLabel[] = new JLabel[num];
			JLabel nameLabel[] = new JLabel[num];

			String name = " ";// 이름 저장
			String faceType = " ";// 캐릭터 타입 저장

			for (int i = 0; i < num; i++) {

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
