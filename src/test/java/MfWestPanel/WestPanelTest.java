package MfWestPanel;

import static org.junit.Assert.*;

import org.junit.Test;

import MfWestPanel.ItemPanel;
import MfWestPanel.SpeedPanel;
import MfWestPanel.WestPanel;

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
