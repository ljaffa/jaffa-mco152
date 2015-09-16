package jaffa.scrabble;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.Assert;

public class ScrabbleDictionaryTest {
	
	@Test
	public void testContains() throws FileNotFoundException{
		ScrabbleDictionary dictionary = new ScrabbleDictionary();
		
		Assert.assertEquals(true, dictionary.contains("ride"));
	}

}
