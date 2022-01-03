package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    
    public static final double EPSILON = 1.0e-15;

    @Test
	public void testDefaultConstructor(){
		// TODO
		Point p = new Point();
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(),EPSILON);
	}

    @Test
	public void testConstructor(){
		// TODO
        Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		Assert.assertEquals(0.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(0.0, p.getCoordinate().getY(),EPSILON);
	}

    @Test
	public void testIsEmpty(){
		// TODO
		Point p = new Point();
		Assert.assertEquals(true, p.isEmpty());
	}

	@Test
	public void testTranslate(){
		//TODO
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		p.translate(1.0, 1.0);
		Assert.assertEquals(1.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(1.0, p.getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testClone(){
		//TODO
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		Point copy = p.clone();
		copy.translate(1.0, 1.0);
		Assert.assertEquals(1.0, copy.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(1.0, copy.getCoordinate().getY(),EPSILON);
		Assert.assertNotEquals(1.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertNotEquals(1.0, p.getCoordinate().getY(),EPSILON);
	}
}
