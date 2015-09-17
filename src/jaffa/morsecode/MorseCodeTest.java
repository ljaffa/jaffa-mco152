package jaffa.morsecode;

import org.junit.Test;
import junit.framework.Assert;

public class MorseCodeTest {
	
	@Test
	public void testEncode(){
		MorseCode mc = new MorseCode();
		String code = mc.encode("Hello world");
		
		Assert.assertEquals(".... . .-.. .-.. ---   .-- --- .-. .-.. -..", code);
	}
	
	@Test
	public void testDecode(){
		MorseCode mc = new MorseCode();
		String message = mc.decode(".... . .-.. .-.. ---   .-- --- .-. .-.. -..");
		
		Assert.assertEquals("Hello world", message);
	}

}
