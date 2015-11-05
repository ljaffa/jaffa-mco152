package jaffa.physics;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest2 {

	@Test
	public void testGetPositiveX(){
		QuadraticEquation q = null;
		try {
			q = new QuadraticEquation(1,3,-4);
		} catch (ImaginaryNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(1, q.getPositiveX(), .1);
	}

}
