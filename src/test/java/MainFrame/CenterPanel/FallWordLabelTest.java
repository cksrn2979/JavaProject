package MainFrame.CenterPanel;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Font;

import org.junit.Before;
import org.junit.Test;

public class FallWordLabelTest {

	@Before
	public void newFallWordLabel(){
		FallWordLabel fallWL=new FallWordLabel("test");
	}
	
	@Test
	public void getHaveItemTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		assertEquals(fallWL.getHaveItem(),false);
	}
	
	@Test
	public void setHaveItem_kTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		Font a=new Font("굴림",Font.BOLD,20);
		fallWL.setHaveItem_k();
		assertEquals(a,fallWL.getFont());
	}
	
	@Test 
	public void setHaveItem_eTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		FallWordLabel fallWL2=new FallWordLabel("test");
	
		fallWL.setHaveItem_e();
		
		fallWL2.setFont(new Font("굴림",Font.BOLD,20));
		fallWL2.setForeground(Color.blue);
		
		assertEquals(fallWL.getForeground(),fallWL2.getForeground());
		assertEquals(fallWL.getFont(),fallWL2.getFont());
	}
	
	@Test
	public void setKoreanTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		
		Font a=new Font("굴림",Font.PLAIN,15);
		
		fallWL.setKorean();
		assertEquals(a,fallWL.getFont());
	}
	
	@Test
	public void setEnglishTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		FallWordLabel fallWL2=new FallWordLabel("test");
	
		fallWL.setEnglish();
		
		fallWL2.setFont(new Font("굴림",Font.BOLD,15));
		fallWL2.setForeground(Color.blue);
		
		assertEquals(fallWL.getForeground(),fallWL2.getForeground());
		assertEquals(fallWL.getFont(),fallWL2.getFont());
	}
	
	@Test
	public void getValidTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		assertEquals(fallWL.getValid(),true);
	}
	
	@Test
	public void setValidTest(){
		FallWordLabel fallWL=new FallWordLabel("test");
		fallWL.setValid(false);
		assertEquals(fallWL.getValid(),false);
	}
}
