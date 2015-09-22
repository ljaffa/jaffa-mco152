package jaffa.morsecode;

import org.junit.Assert;
import org.junit.Test;


public class MorseCodeTest {
	
	@Test
	public void testEncode(){
		MorseCode mc = new MorseCode();
		String code = mc.encode("HELLO WORLD");
		
		Assert.assertEquals(".... . .-.. .-.. ---   .-- --- .-. .-.. -..", code);
	}
	
	@Test
	public void testDecode(){
		MorseCode mc = new MorseCode();
		String message = mc.decode(".... . .-.. .-.. ---   .-- --- .-. .-.. -..");
		
		Assert.assertEquals("HELLO WORLD", message);
	}

}
