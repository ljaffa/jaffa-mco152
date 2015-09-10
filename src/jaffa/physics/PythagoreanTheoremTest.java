package jaffa.physics;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	
	/*@Test
	public void testSetAB(){
		PythagoreanTheorem pt = new PythagoreanTheorem(3, 4, 5);
		pt.setAB();
		double c = pt.getC();
		
		Assert.assertEquals(25, c, .1);
	}
	
	@Test
	public void testSetAC(){
		PythagoreanTheorem pt = new PythagoreanTheorem(3, 4, 5);
		pt.setAC();
		double b = pt.getB();
		
		Assert.assertEquals(16, b, .1);
	}
	
	@Test
	public void testSetBC(){
		PythagoreanTheorem pt = new PythagoreanTheorem(3, 4, 5);
		pt.setBC();
		double a = pt.getA();
		
		Assert.assertEquals(9, a, .1);
	}*/
	
	@Test
	public void testSetAB(){
		PythagoreanTheorem pt = new PythagoreanTheorem();
		pt.setAB(3, 4);
		double c = pt.getC();
		
		Assert.assertEquals(5, c, 0.1);
	}
	
	@Test
	public void testSetAC(){
		PythagoreanTheorem pt = new PythagoreanTheorem();
		pt.setAC(3, 5);
		double b = pt.getB();
		
		Assert.assertEquals(4, b, 0.1);
	}
	
	@Test
	public void testSetBC(){
		PythagoreanTheorem pt = new PythagoreanTheorem();
		pt.setBC(4, 5);
		double a = pt.getA();
		
		Assert.assertEquals(3, a, 0.1);
	}

}
