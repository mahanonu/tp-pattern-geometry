package org.acme.geometry;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testGetEnvelope(){
        Point p1 = new Point(new Coordinate(0.0,1.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		Geometry l = new LineString(al);
        l = new GeometryWithCachedEnvelope(l);
        Envelope e1 = l.getEnvelope();
        Envelope e2 = l.getEnvelope();
        Assert.assertSame(e1,e2);
    }

    @Test
    public void testOnChange(){
        Point p1 = new Point(new Coordinate(0.0,1.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		Geometry l = new LineString(al);
        l = new GeometryWithCachedEnvelope(l);
        Envelope e1 = l.getEnvelope();
        l.translate(1.0, 1.0);
        Assert.assertEquals(1.0, l.getEnvelope().getXmin(),EPSILON);
        Assert.assertEquals(3.0, l.getEnvelope().getXmax(),EPSILON);
        Assert.assertEquals(2.0, l.getEnvelope().getYmin(),EPSILON);
        Assert.assertEquals(4.0, l.getEnvelope().getYmax(),EPSILON);
    }

}
