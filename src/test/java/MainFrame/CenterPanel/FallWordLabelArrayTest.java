package MainFrame.CenterPanel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import MainFrame.CenterPanel.FallWordLabel;
import MainFrame.CenterPanel.FallWordLabelArray;

public class FallWordLabelArrayTest {
	
	@Before
	public void removeTest(){
		FallWordLabelArray fallWordLabelArray = new FallWordLabelArray();
		FallWordLabel wla=new FallWordLabel("korean");
		fallWordLabelArray.add(wla);
		fallWordLabelArray.remove(0);
		assertEquals(fallWordLabelArray.getNumOfLabel(),0);
	}

	@Test
	public void getLabelTest() {
		FallWordLabelArray fallWordLabelArray = new FallWordLabelArray();
		FallWordLabel wla=new FallWordLabel("korean");
		fallWordLabelArray.add(wla);
		assertEquals(fallWordLabelArray.getLabel(0),wla);
		fallWordLabelArray.remove(0);
	}
	
	
	@Test
	public void getTextTest() {
		FallWordLabelArray fallWordLabelArray = new FallWordLabelArray();
		FallWordLabel wla=new FallWordLabel("korean");
		fallWordLabelArray.add(wla);
		assertEquals(fallWordLabelArray.getText(0),wla.getText());
		fallWordLabelArray.remove(0);
	}
	
	@Test
	public void setTextTest() {
		FallWordLabelArray fallWordLabelArray = new FallWordLabelArray();
		FallWordLabel wla=new FallWordLabel("korean");
		fallWordLabelArray.add(wla);
		fallWordLabelArray.setText(0,"english");
		assertEquals(fallWordLabelArray.getText(0),"english");
		fallWordLabelArray.remove(0);
	}
	
	
}
