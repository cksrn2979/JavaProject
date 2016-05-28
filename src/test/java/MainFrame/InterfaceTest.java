package MainFrame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Interface.GameSet;

public class InterfaceTest {
	
	@Test
	public void getUserTest() {
		assertEquals(GameSet.getUser(),"서송이");
	}
	
	@Test
	public void getPlayTest() {
		assertEquals(GameSet.getPlay(),false);
	}
	
	@Test
	public void getTurnTest() {
		assertEquals(GameSet.getTurn(),true);
	}
	
	@Test
	public void getLevelTest() {
		Integer L1=1;
		assertEquals(GameSet.getLevel(),L1);
	}

	@Test
	public void getSpeedTest() {
		Double L1=5.0;
		assertEquals(GameSet.getSpeed(),L1);
	}
	
	@Test
	public void getGameTryTest() {
		Integer L1=1;
		assertEquals(GameSet.getGameTry(),L1);
	}	
	
	@Test
	public void setPlayTest() {
		GameSet.setStop();
		assertEquals(GameSet.getPlay(),false);
	}
	
	@Test
	public void setLebelTest() {
		GameSet.setLevel(5);
		Integer L1=5;
		assertEquals(GameSet.getLevel(),L1);
	}
	
	@Test
	public void setSpeedTest() {
		GameSet.setSpeed(5.0);
		Double L1=5.0;
		assertEquals(GameSet.getSpeed(),L1);
	}
	
	@Test
	public void ScoreUPTest() {
		GameSet.scoreUp();
		Integer L1=20;
		assertEquals(GameSet.getScore(),L1);
	}
	
	@Test
	public void setGameTryTest() {
		GameSet.setGameTry(5);
		Integer L1=5;
		assertEquals(GameSet.getGameTry(),L1);
	}
	
	@Test
	public void setUserTest() {
		GameSet.setUser("서송이");
		assertEquals(GameSet.getUser(),"서송이");
	}
	
	@Test
	public void speedUpTest() {
		GameSet.speedUp(1);
		Double L1=6.0;
		assertEquals(GameSet.getSpeed(),L1);
	}
	
	@Test
	public void setKoreanTurnTest() {
		GameSet.setKoreanTurn();
		assertEquals(GameSet.getTurn(),true);
	}
	
	@Test
	public void setEnglishTurnTest() {
		GameSet.setEnglishTurn();
		assertEquals(GameSet.getTurn(),true);
	}
}
