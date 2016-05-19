package GameInterface;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import MfCenterPanel.FallWordLabel;
import MfCenterPanel.FallWordLabelArray;

public class WordLabelArrayTest {
	
	@Before
	public void removeTest(){
		FallWordLabel wla=new FallWordLabel("korean");
		FallWordLabelArray.add(wla);
		FallWordLabelArray.remove(0);
		assertEquals(FallWordLabelArray.getNumOfLabel(),0);
	}

	@Test
	public void getTest() {
		FallWordLabel wla=new FallWordLabel("korean");
		FallWordLabelArray.add(wla);
		assertEquals(FallWordLabelArray.get(0),wla);
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
