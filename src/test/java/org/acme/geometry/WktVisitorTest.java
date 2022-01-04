package org.acme.geometry;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
    
    public static Coordinate c1 = new Coordinate(0.0,1.0);
    public static Coordinate c2 = new Coordinate(2.0,3.0);
	public static Point p1 = new Point(c1);
    public static Point p2 = new Point(c2);
    
    @Test
    public void testVisitPoint(){
        WktVisitor visitor = new WktVisitor();
        p1.accept(visitor);
        Assert.assertEquals("POINT(0.0 1.0)", visitor.getResult());
    }

    @Test
    public void testVisitLineString(){
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
        WktVisitor visitor = new WktVisitor();
        l.accept(visitor);
        Assert.assertEquals("LINESTRING(0.0 1.0,2.0 3.0)", visitor.getResult());
    }
}