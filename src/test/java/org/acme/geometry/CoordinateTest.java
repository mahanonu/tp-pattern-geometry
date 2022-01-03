package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		// TODO
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
	}

	@Test
	public void testConstructor(){
		// TODO
		Coordinate c = new Coordinate(0.0,0.0);
		Assert.assertEquals(0.0, c.getX(), EPSILON);
		Assert.assertEquals(0.0, c.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		// TODO
		Coordinate c1 = new Coordinate();
		Coordinate c2 = new Coordinate(0.0,0.0);
		Assert.assertEquals(true, c1.isEmpty());
		Assert.assertEquals(false, c2.isEmpty());
	}

}
