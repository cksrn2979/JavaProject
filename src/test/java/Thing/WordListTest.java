package Thing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Word.Word;

public class WordListTest {

	@Test
	public void newWordListTest() {
		new Word();
	}
	
	@Test
	public void WordListaddTest(){
		Word word = new Word();
		word.add("korean","english");
	}
	
	@Test
	public void WordListgetTest(){
		Word word = new Word();
		word.add("korean","english");
		assertEquals(word.get(),"korean");
	}
	
	@Test
	public void WordListRenderTest(){
		Word word = new Word();
		word.add("korean","english");
		assertEquals(word.render("korean"),"english");
	}
	
	@Test
	public void WordListRenderTest2(){
		Word word = new Word();
		word.add("korean","english");
		assertEquals(word.render("english"),null);
	}
	
	@Test
	public void WordListgetSuccessTest(){
		Word word = new Word();
		word.add("korean","english");
		assertEquals(word.getSuccess("korean").intValue(),0);
	}
	
	@Test
	public void WordListplusSuccessTest(){
		Word word = new Word();
		word.add("korean","english");
		word.plusSuccess("korean");
		assertEquals(word.getSuccess("korean").intValue(),1);
	}

}
