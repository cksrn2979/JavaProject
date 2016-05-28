package Interface;

public class GameSet {
	private static boolean play=true;
	private static boolean turn=true; //입력 차례 (한글,영문)
	private static Integer level=1; 
	private static Double speed=5.0;
	private static Integer score=0;
	private static String character; //retry 횟수
	private static String user="";
	
	public static boolean getTurn(){return turn;}
	public static boolean getPlay(){return play;}	
	public static Integer getLevel(){return level;}	
	public static Double getSpeed(){return speed;}	
	public static Integer getScore(){return score;}	
	public static String getCharacter(){return character;}	
	public static String getUser(){return user;}
	
	public static void setPlay(){GameSet.play=true;}
	public static void setStop(){GameSet.play=false;}
	public static void setLevel(Integer level){GameSet.level=level;}
	public static void setSpeed(Double speed){GameSet.speed=speed;}
	public static void setCharacter(String chracter){GameSet.character=chracter;}
	public static void setUser(String user){GameSet.user=user;}
	
	public static void speedUp(double up){speed+=up;} //속도 업
	public static void setKoreanTurn(){turn=true;} //한글 입력 차례로
	public static void setEnglishTurn(){turn=true;} //영문 입력 차례로
	
	public static void scoreUp(){score+=level*20;} //점수 증가

}
