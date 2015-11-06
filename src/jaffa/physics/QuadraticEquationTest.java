package jaffa.physics;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetNegativeX() throws ImaginaryNumberException, DivideByZeroException {
		QuadraticEquation q = null;
		q = new QuadraticEquation(1, 3, -4);
		double x = q.getNegativeX();

		Assert.assertEquals(-4, x, .1);
	}

	@Test
	public void testGetPositiveX() throws ImaginaryNumberException, DivideByZeroException {
		QuadraticEquation q = null;
		q = new QuadraticEquation(1, 3, -4);

		double x = q.getPositiveX();

		Assert.assertEquals(1, x, .1);
	}

	@Test
	public void testThrowsInvalidException() throws ImaginaryNumberException, DivideByZeroException {
		// test to make sure that exceptions are being thrown
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("Didn't throw Exception");
		} catch (ImaginaryNumberException e) {

		} catch (DivideByZeroException e) {
			
		}
	}
}
