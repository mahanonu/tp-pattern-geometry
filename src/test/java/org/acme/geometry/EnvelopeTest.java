package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
    
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
		// TODO
		Envelope e = new Envelope();
		Assert.assertEquals(Double.NaN, e.getXmin(),EPSILON);
		Assert.assertEquals(Double.NaN, e.getXmax(),EPSILON);
        Assert.assertEquals(Double.NaN, e.getYmin(),EPSILON);
		Assert.assertEquals(Double.NaN, e.getYmax(),EPSILON);
	}

    @Test
    public void testConstructor(){
		// TODO
		Envelope e = new Envelope(new Coordinate(0.0,1.0),new Coordinate(2.0,3.0));
		Assert.assertEquals(0.0, e.getXmin(),EPSILON);
		Assert.assertEquals(2.0, e.getXmax(),EPSILON);
        Assert.assertEquals(1.0, e.getYmin(),EPSILON);
		Assert.assertEquals(3.0, e.getYmax(),EPSILON);
	}

}
