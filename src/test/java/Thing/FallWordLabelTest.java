package Thing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FallWordLabelTest {
	
	@Before
	public void removeTest(){
		WordLabel wla=new WordLabel("korean");
		FallWordLabel.add(wla);
		FallWordLabel.remove(0);
		assertEquals(FallWordLabel.getNumOfLabel(),0);
	}

	@Test
	public void getTest() {
		WordLabel wla=new WordLabel("korean");
		FallWordLabel.add(wla);
		assertEquals(FallWordLabel.get(0),wla);
		FallWordLabel.remove(0);
	}
	
	
	@Test
	public void getTextTest() {
		WordLabel wla=new WordLabel("korean");
		FallWordLabel.add(wla);
		assertEquals(FallWordLabel.getText(0),wla.getText());
		FallWordLabel.remove(0);
	}
	
	@Test
	public void setTextTest() {
		WordLabel wla=new WordLabel("korean");
		FallWordLabel.add(wla);
		FallWordLabel.setText(0,"english");
		assertEquals(FallWordLabel.getText(0),"english");
		FallWordLabel.remove(0);
	}
	
	
}
