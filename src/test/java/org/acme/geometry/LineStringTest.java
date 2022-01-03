package org.acme.geometry;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
    
    public static final double EPSILON = 1.0e-15;

    @Test
	public void testDefaultConstructor(){
		// TODO
		LineString l = new LineString();
		Assert.assertEquals(true, l.isEmpty());
	}

    @Test
	public void testConstructor(){
		// TODO
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(1.0,1.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
		Assert.assertEquals(false, l.isEmpty());
        Assert.assertEquals(2,l.getNumPoints(),EPSILON);
        Assert.assertEquals(p1, l.getPointN(0));
	}
}

