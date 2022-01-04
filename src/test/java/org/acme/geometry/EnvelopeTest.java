package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
    
    public static final double EPSILON = 1.0e-15;
	public static Envelope e1 = new Envelope();
	public static Envelope e2 = new Envelope(new Coordinate(0.0,1.0),new Coordinate(2.0,3.0));

    @Test
    public void testDefaultConstructor(){
		// TODO
		Assert.assertEquals(Double.NaN, e1.getXmin(),EPSILON);
		Assert.assertEquals(Double.NaN, e1.getXmax(),EPSILON);
        Assert.assertEquals(Double.NaN, e1.getYmin(),EPSILON);
		Assert.assertEquals(Double.NaN, e1.getYmax(),EPSILON);
	}

    @Test
    public void testConstructor(){
		// TODO
		Assert.assertEquals(0.0, e2.getXmin(),EPSILON);
		Assert.assertEquals(2.0, e2.getXmax(),EPSILON);
        Assert.assertEquals(1.0, e2.getYmin(),EPSILON);
		Assert.assertEquals(3.0, e2.getYmax(),EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Assert.assertEquals(true, e1.isEmpty());
		Assert.assertEquals(false, e2.isEmpty());
	}
}
