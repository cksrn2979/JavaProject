package PlayPanel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import MainFrame.MainFrame;
import PlayPanel.Play.MakeWord.FallingAni;
import RankFrame.RankFrame;
import PlayPanel.CenterPanel.FallWordLabel;

public class Play {
	private PlayPanel playPanel;
	private boolean play;
	private boolean turn; //입력 차례 (한글,영문)
	private Integer level; 
	private Double speed;
	private Integer score;	
	private int count;
	private Integer heart;

	private Vector<FallingAni> fallingAniArray;
	private MakeWord makeWord;
	private SpeedAni speedAni;	
	
	Play(PlayPanel playPanel, Integer level, Double speed){
		this.playPanel=playPanel;
		this.level=level;
		this.speed=speed;
		this.score=0;
		this.play=true;
		this.turn=true; //입력 차례 (한글,영문)
		this.count=10;
		this.heart=100;
		
		speedAni=new SpeedAni();
		fallingAniArray=new Vector<FallingAni>();
		makeWord=new MakeWord(); //단어 생성 시작
	}
		
	public boolean getTurn(){return turn;}
	public Integer getLevel(){return level;}	
	public Double getSpeed(){return speed;}	
	public Integer getScore(){return score;}	
	public boolean getPlay(){return play;}	
	
	public void setSpeed(Double speed){this.speed=speed;}
	public void setlevel(int level){this.level=level;}
	public void speedUp(double up){this.speed+=up;} //속도 업
	public void setKoreanTurn(){this.turn=true;} //한글 입력 차례로
	public void setEnglishTurn(){this.turn=false;} //영문 입력 차례로

	public void pain(){ //체력 감소
		heart-=20;
		playPanel.cp.heartGagePa.heartgage.setValue(heart);
		playPanel.cp.heartGagePa.heartgage.setString(heart.toString()+"%");	
		
		if(heart==0)	
			gameOver();
	}
	
	public void fullGain(){
		heart=100;
		playPanel.cp.heartGagePa.heartgage.setValue(heart);
		playPanel.cp.heartGagePa.heartgage.setString(heart.toString()+"%");	
	}
	
	public void levelUp() {
		level++;
		playPanel.np.levelPa.setLevelText(level.toString());
		playPanel.cp.clearLabel();
		playPanel.cp.levelUpLabel.action(2000);
	}

	public void scoreUp() {// 점수 증가
		count--;
		score += level * 1;
		playPanel.np.scorePa.setScoreText(score.toString());
		if (count == 0) {
			levelUp();
			count = 10;
		}
	}

	public void startGame() {
		speedAni.start();
		makeWord.start();
	}

	public void stopGame() {
		speedAni.interrupt();
		makeWord.interrupt();
		for (int i = 0; i < fallingAniArray.size(); i++)
			fallingAniArray.get(i).interrupt();
	}

	public void pauseGame() {
		this.play = false;
		speedAni.suspend();
		makeWord.suspend();
		for (int i = 0; i < fallingAniArray.size(); i++)
			fallingAniArray.get(i).suspend();
	}

	public void resumeGame() {
		this.play = true;
		speedAni.resume();
		makeWord.resume();
		for (int i = 0; i < fallingAniArray.size(); i++)
			fallingAniArray.get(i).resume();
	}

	public void gameOver() {		
		Thread gameOverThread = new Thread(){
			public void run(){
				stopGame();
				writeFinal();
				playPanel.dictionary.writeWordUserDictionary();
				new RankFrame(playPanel);
			}
		};			
		gameOverThread.start();
	}
	
	public void goHome(){
		stopGame();
		MainFrame mf= (MainFrame)playPanel.getTopLevelAncestor();
		mf.setContentPane(mf.mainPanel);
		mf.repaint();
		mf.revalidate();
	}

	private void writeFinal() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("resources/Score.txt", true));
			BufferedReader in2 = new BufferedReader(new FileReader("resources/User.txt"));
			String name = playPanel.userInfo.getUser();
			String ch = " ";
			String s;
			while ((s = in2.readLine()) != null) {
				String[] split = s.split("\t");
				if (split[1].equals(name)) {
					ch = split[0];
				}
			}
			out.write(ch + '\t' + name + '\t' + score);
			out.newLine();
			in2.close();
			out.close();
		} catch (IOException e) {
			return;
		}
	}

	class SpeedAni extends Thread {
		public void run() {
			NumberFormat numberFormat = new DecimalFormat("##.##");
			while (true) {
				speedUp(0.01);
				playPanel.wp.speedPanel.setSpeedText(numberFormat.format(speed));

				try {
					sleep(100);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}

	class MakeWord extends Thread {
		public void run() {
			while (true) {
				FallingAni fallingAni = new FallingAni();
				fallingAniArray.add(fallingAni);
				fallingAni.start();

				try {
					sleep(4000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}

		class FallingAni extends Thread {
			public void run() {
				// 좌표값 설정
				int x = (int) (Math.random() * 400);
				int y = 50;

				// 단어를 랜덤하게 받아와 라벨 생성.
				FallWordLabel la = new FallWordLabel(playPanel.dictionary.rand());

				// 떨어지는 라벨 배열 추가
				playPanel.cp.getLabelArray().add(la);

				// 위치 설정
				la.setLocation(x, y);

				// 패널에 추가
				playPanel.cp.add(la);

				// y<410까지 떨어트림
				while (y < 410 && !Thread.currentThread().isInterrupted()) {
					y = (int) (y + speed);
					la.setLocation(x, y);
					try {
						sleep(1000); // 떨어지는 속도
					} catch (InterruptedException e) {
						return;
					}
				}

				if (y >= 410 && la.getValid() == true) {
					pain(); // 체력 감소
					playPanel.cp.getLabelArray().remove(la); // 배열에서 제거

					// 영어 라벨이 다 떨어지면, 한글 차례로
					if (la.getLanguage() == false)
						turn = true;
				}

				fallingAniArray.remove(this);

				return;
			}

		}// FallingAni 클래스 끝
	}
}
