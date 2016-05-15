package MainFrame;

import static org.junit.Assert.*;

import org.junit.Test;

import MainFrame.EastPanel;
import MainFrame.InformationPanel;
import MainFrame.SuccessWordPanel;
import MainFrame.WordSetPanel;

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
