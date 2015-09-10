package jaffa.physics;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {
	
	@Test
	public void testGetPositiveX(){
		QuadraticEquation q = new QuadraticEquation(1, 3, (-4));
		double x = q.getPositiveX();
		
		Assert.assertEquals(1, x, .1);
	}
	
	@Test
	public void testGetNegativeX(){
		QuadraticEquation q = new QuadraticEquation(1, 3, (-4));
		double x = q.getNegativeX();
		
		Assert.assertEquals((-4), x, .1);
	}
	
	@Test
	public void testGetNegativeX1(){
		QuadraticEquation q = new QuadraticEquation(0, 3, (-4));
		double x = q.getNegativeX();
		
		Assert.assertEquals((-4), x, .1);
	}

}
