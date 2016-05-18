package EastPanel;

import static org.junit.Assert.*;

import org.junit.Test;

import EastPanel.EastPanel;
import EastPanel.InformationPanel;
import EastPanel.SuccessWordPanel;
import EastPanel.WordSetPanel;

public class EastPanelTest {

	@Test
	public void newEastPaneltest() {
		new EastPanel();
	}
	
	@Test
	public void newWordSetPanelTest(){
		new WordSetPanel();
	}
	
	@Test
	public void newSuccessWordPanelTest(){
		new SuccessWordPanel();
	}
	
	@Test
	public void newInfomaitonPanelTest(){
		new InformationPanel();
	}

}
