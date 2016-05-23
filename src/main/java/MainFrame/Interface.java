package MainFrame;

public class Interface {
	private static boolean play=true; //게임 진행,멈춤
	private static boolean turn=true; //입력 차례 (한글,영문)
	private static Integer level=1; 
	private static Double speed=5.0;
	private static Integer score=0;
	private static Integer gameTry=1; //retry 횟수
	private static String user="";
	
	public static boolean getTurn(){return turn;}
	public static boolean getPlay(){return play;}	
	public static Integer getLevel(){return level;}	
	public static Double getSpeed(){return speed;}	
	public static Integer getScore(){return score;}	
	public static Integer getGameTry(){return gameTry;}	
	public static String getUser(){return user;}
	
	public static void setPlay(boolean play){Interface.play=play;}
	public static void setLevel(Integer level){Interface.level=level;}
	public static void setSpeed(Double speed){Interface.speed=speed;}
	public static void setGameTry(Integer gameTry){Interface.gameTry=gameTry;}
	public static void setUser(String user){Interface.user=user;}
	
	public static void speedUp(double up){speed+=up;} //속도 업
	public static void setKoreanTurn(){turn=true;} //한글 입력 차례로
	public static void setEnglishTurn(){turn=true;} //영문 입력 차례로
	
	public static void scoreUp(){score+=level*20;} //점수 증가
}
