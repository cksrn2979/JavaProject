package MainFrame;

import static org.junit.Assert.*;

import org.junit.Test;

import MainFrame.ItemPanel;
import MainFrame.SpeedPanel;
import MainFrame.WestPanel;

public class WestPanelTest {

	@Test
	public void newWestPaneltest() {
		new WestPanel();
	}
	
	@Test
	public void newSpeedPaneltest() {
		new SpeedPanel();
	}
	
	@Test
	public void newItemPaneltest() {
		new ItemPanel();
	}

}
