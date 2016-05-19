package MyDictionary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import MyDictionary.MyDictionary;


public class MyDictionaryTest {

	@Test
	public void addTest(){
		MyDictionary.add("korean","english");
	}
	
	@Test
	public void randTest(){
		MyDictionary.add("korean","english");
		assertEquals(MyDictionary.rand(),"korean");
	}
	
	@Test
	public void renderTest(){
		MyDictionary.add("korean","english");
		assertEquals(MyDictionary.render("korean"),"english");
	}
	
	@Test
	public void renderTest2(){
		MyDictionary.add("korean","english");
		assertEquals(MyDictionary.render("english"),null);
	}
	
	@Test
	public void getSuccessTest(){
		MyDictionary.add("korean","english");
		assertEquals(MyDictionary.getSuccess("korean").intValue(),0);
	}
	
	@Test
	public void plusSuccessTest(){
		MyDictionary.add("korean","english");
		MyDictionary.plusSuccess("korean");
		assertEquals(MyDictionary.getSuccess("korean").intValue(),1);
	}

}
