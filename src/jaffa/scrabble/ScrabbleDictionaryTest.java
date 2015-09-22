package jaffa.scrabble;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;



public class ScrabbleDictionaryTest {
	
	@Test
	public void testContains() throws FileNotFoundException{
		ScrabbleDictionary dictionary = new ScrabbleDictionary();
		
		Assert.assertTrue(dictionary.contains("ride"));
	}

}
