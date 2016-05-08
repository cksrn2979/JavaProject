package TypeTrainer;

import static org.junit.Assert.*;

import java.awt.*;

import org.junit.*;

public class MainFrameTest {	
	
	@Before	
	public void newTest(){
		MainFrame mf = new MainFrame();
		
	}	
	
	@Test
	public void addTest(){
		MainFrame mf = new MainFrame();
		Container c = mf.getContentPane();
		
		c.add(new RightPanel(),BorderLayout.EAST);
	}

}
