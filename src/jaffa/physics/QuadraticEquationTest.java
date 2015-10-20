package jaffa.physics;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetNegativeX() {
		QuadraticEquation q = null;
		try {
			q = new QuadraticEquation(1, 3, -4);
		} catch (ImaginaryNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double x = q.getNegativeX();

		Assert.assertEquals(-4, x, .1);
	}

	@Test
	public void testGetPositiveX() {
		QuadraticEquation q = null;
		try {
			q = new QuadraticEquation(1, 3, -4);
		} catch (ImaginaryNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double x = q.getPositiveX();

		Assert.assertEquals(1, x, .1);
	}

	@Test
	public void testThrowsInvalidException() {
		// test to make sure that exceptions are being thrown
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("Didn't throw Exception");
		} catch (ImaginaryNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
