package MainFrame;

public class Interface {
	private static boolean play=true;
	private static Integer level=1;
	private static Double speed=5.0;
	private static Integer score=0;
	private static Integer gameTry=1;
	private static String user="서송이";
	
	public static boolean getPlay(){return play;}	
	public static Integer getLevel(){return level;}	
	public static Double getSpeed(){return speed;}	
	public static Integer getScore(){return score;}	
	public static Integer getGameTry(){return gameTry;	}	
	public static String getUser(){return user;}
	
	public static void setPlay(boolean play){Interface.play=play;}
	public static void setLevel(Integer level){Interface.level=level;}
	public static void setSpeed(Double speed){Interface.speed=speed;}
	public static void setScore(Integer score){Interface.score=score;}
	public static void setGameTry(Integer gameTry){Interface.gameTry=gameTry;}
	public static void setUser(String user){Interface.user=user;}
	
	public static void speedUp(double up){speed+=up;}
}
