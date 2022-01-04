package org.acme.geometry;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {
    
    public static final double EPSILON = 1.0e-15;
    public static EnvelopeBuilder builder = new EnvelopeBuilder();
    public static Coordinate c1 = new Coordinate(0.0,1.0);
    public static Coordinate c2 = new Coordinate(2.0,3.0);
    public static Point p1 = new Point(c1);
    public static Point p2 = new Point(c2);

    @Test
    public void testBuild(){
		// TODO
    ArrayList<Point> al = new ArrayList<>();
    al.add(p1);
    al.add(p2);
		LineString l = new LineString(al);
		builder.visit(p1);
    builder.visit(l);
    Envelope e = builder.build();
    Assert.assertEquals(0.0, e.getXmin(),EPSILON);
    Assert.assertEquals(2.0, e.getXmax(),EPSILON);
    Assert.assertEquals(1.0, e.getYmin(),EPSILON);
    Assert.assertEquals(3.0, e.getYmax(),EPSILON);
	}
}
