package MainFrame.CenterPanel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import MainFrame.CenterPanel.FallWordLabel;
import MainFrame.CenterPanel.FallWordLabelArray;

public class FallWordLabelArrayTest {
	
	@Before
	public void removeTest(){
		FallWordLabel wla=new FallWordLabel("korean");
		FallWordLabelArray.add(wla);
		FallWordLabelArray.remove(0);
		assertEquals(FallWordLabelArray.getNumOfLabel(),0);
	}

	@Test
	public void getLabelTest() {
		FallWordLabel wla=new FallWordLabel("korean");
		FallWordLabelArray.add(wla);
		assertEquals(FallWordLabelArray.getLabel(0),wla);
		FallWordLabelArray.remove(0);
	}
	
	
	@Test
	public void getTextTest() {
		FallWordLabel wla=new FallWordLabel("korean");
		FallWordLabelArray.add(wla);
		assertEquals(FallWordLabelArray.getText(0),wla.getText());
		FallWordLabelArray.remove(0);
	}
	
	@Test
	public void setTextTest() {
		FallWordLabel wla=new FallWordLabel("korean");
		FallWordLabelArray.add(wla);
		FallWordLabelArray.setText(0,"english");
		assertEquals(FallWordLabelArray.getText(0),"english");
		FallWordLabelArray.remove(0);
	}
	
	
}
