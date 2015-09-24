package jaffa.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary dictionary = new ScrabbleDictionary();

		Assert.assertTrue(dictionary.contains("ride"));
	}

}
