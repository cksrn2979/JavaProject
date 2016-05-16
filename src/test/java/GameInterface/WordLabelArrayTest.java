package GameInterface;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import GameInterface.WordLabelArray;
import GameInterface.WordLabel;

public class WordLabelArrayTest {
	
	@Before
	public void removeTest(){
		WordLabel wla=new WordLabel("korean");
		WordLabelArray.add(wla);
		WordLabelArray.remove(0);
		assertEquals(WordLabelArray.getNumOfLabel(),0);
	}

	@Test
	public void getTest() {
		WordLabel wla=new WordLabel("korean");
		WordLabelArray.add(wla);
		assertEquals(WordLabelArray.get(0),wla);
		WordLabelArray.remove(0);
	}
	
	
	@Test
	public void getTextTest() {
		WordLabel wla=new WordLabel("korean");
		WordLabelArray.add(wla);
		assertEquals(WordLabelArray.getText(0),wla.getText());
		WordLabelArray.remove(0);
	}
	
	@Test
	public void setTextTest() {
		WordLabel wla=new WordLabel("korean");
		WordLabelArray.add(wla);
		WordLabelArray.setText(0,"english");
		assertEquals(WordLabelArray.getText(0),"english");
		WordLabelArray.remove(0);
	}
	
	
}
