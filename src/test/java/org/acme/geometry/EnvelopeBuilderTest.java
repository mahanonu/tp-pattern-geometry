package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {
    
    public static final double EPSILON = 1.0e-15;
    public static EnvelopeBuilder builder = new EnvelopeBuilder();
    public static Coordinate c1 = new Coordinate(0.0,1.0);
    public static Coordinate c2 = new Coordinate(2.0,3.0);

    @Test
    public void testBuild(){
		// TODO
		builder.insert(c1);
        builder.insert(c2);
        Envelope e = builder.build();
        Assert.assertEquals(0.0, e.getXmin(),EPSILON);
        Assert.assertEquals(2.0, e.getXmax(),EPSILON);
        Assert.assertEquals(1.0, e.getYmin(),EPSILON);
        Assert.assertEquals(3.0, e.getYmax(),EPSILON);
	}
}
