package WestPanel;

import static org.junit.Assert.*;

import org.junit.Test;

import WestPanel.ItemPanel;
import WestPanel.SpeedPanel;
import WestPanel.WestPanel;

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
