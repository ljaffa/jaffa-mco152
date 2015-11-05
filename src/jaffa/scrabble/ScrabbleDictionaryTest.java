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

	@Test
	public void testContains2() throws IOException {
		ScrabbleDictionary dic = new ScrabbleDictionary();

		Assert.assertTrue(dic.contains("crate"));
	}
}
