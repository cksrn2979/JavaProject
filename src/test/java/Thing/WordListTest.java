package Thing;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordListTest {

	@Test
	public void newWordListTest() {
		new WordList();
	}
	
	@Test
	public void WordListaddTest(){
		WordList allWord = new WordList();
		allWord.add("korean","english");
	}
	
	@Test
	public void WordListgetTest(){
		WordList wordList = new WordList();
		wordList.add("korean","english");
		assertEquals(wordList.get(),"korean");
	}
	
	@Test
	public void WordListRenderTest(){
		WordList wordList = new WordList();
		wordList.add("korean","english");
		assertEquals(wordList.render("korean"),"english");
	}

}
