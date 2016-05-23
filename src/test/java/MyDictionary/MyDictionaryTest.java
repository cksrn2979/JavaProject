package MyDictionary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import MyDictionary.MyDictionary;


public class MyDictionaryTest {

	@Test
	public void addTest(){
		MyDictionary.add("korean","english",0);
	}
	
	@Test
	public void getNumOfWordTest(){
		assertEquals(MyDictionary.getNumOfWord(),2);
	}
	
	@Test
	public void getWordTest(){
		assertEquals(MyDictionary.getWord(0),"korean");
	}
	
	@Test
	public void randTest(){
		MyDictionary.add("korean","english",0);
		assertEquals(MyDictionary.rand(),"korean");
	}
	
	@Test
	public void renderTest(){
		MyDictionary.add("korean","english",0);
		assertEquals(MyDictionary.render("korean"),"english");
	}
	
	@Test
	public void renderTest2(){
		MyDictionary.add("korean","english",0);
		assertEquals(MyDictionary.render("english"),null);
	}
	
	@Test
	public void renderReverseTest(){
		MyDictionary.add("korean","english",0);
		assertEquals(MyDictionary.renderReverse("english"),"korean");
	}
	
	@Test
	public void getSuccessTest(){
		MyDictionary.add("korean","english",0);
		assertEquals(MyDictionary.getSuccess("korean").intValue(),0);
	}

	@Test
	public void plusSuccessTest(){
		MyDictionary.add("korean","english",0);
		MyDictionary.plusSuccess("korean");
		assertEquals(MyDictionary.getSuccess("korean").intValue(),1);
	}

}
