package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    
    public static final double EPSILON = 1.0e-15;
	public static Coordinate c = new Coordinate(0.0,1.0);
	public static Point p1 = new Point();
	public static Point p2 = new Point(c);

    @Test
	public void testDefaultConstructor(){
		// TODO
		Assert.assertEquals(Double.NaN, p1.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(Double.NaN, p1.getCoordinate().getY(),EPSILON);
	}

    @Test
	public void testConstructor(){
		// TODO
		Assert.assertEquals(0.0, p2.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(1.0, p2.getCoordinate().getY(),EPSILON);
	}

    @Test
	public void testIsEmpty(){
		// TODO
		Assert.assertEquals(true, p1.isEmpty());
	}

	@Test
	public void testTranslate(){
		//TODO
		Coordinate c = new Coordinate(0.0,1.0);
		Point p = new Point(c);
		p.translate(1.0, 1.0);
		Assert.assertEquals(1.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(2.0, p.getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testClone(){
		//TODO
		Coordinate c = new Coordinate(0.0,1.0);
		Point p = new Point(c);
		Point copy = p.clone();
		copy.translate(1.0, 1.0);
		Assert.assertEquals(1.0, copy.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(2.0, copy.getCoordinate().getY(),EPSILON);
		Assert.assertNotEquals(1.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertNotEquals(2.0, p.getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testGetEnvelope(){
		//TODO
		Envelope e = p2.getEnvelope();
		Assert.assertEquals(0.0, e.getXmin(),EPSILON);
		Assert.assertEquals(0.0, e.getXmax(),EPSILON);
		Assert.assertEquals(1.0, e.getYmin(),EPSILON);
		Assert.assertEquals(1.0, e.getYmax(),EPSILON);
	}
}
