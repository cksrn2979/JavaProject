package MfEastPanel;

import static org.junit.Assert.*;

import org.junit.Test;

import MfEastPanel.EastPanel;
import MfEastPanel.InformationPanel;
import MfEastPanel.SuccessWordPanel;
import MfEastPanel.WordSetPanel;

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
