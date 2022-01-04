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
        Point p1 = new Point(new Coordinate(0.0,1.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
		Assert.assertEquals(false, l.isEmpty());
        Assert.assertEquals(2,l.getNumPoints(),EPSILON);
        Assert.assertEquals(p1, l.getPointN(0));
	}

    @Test
    public void testTranslate(){
        //TODO
        Point p1 = new Point(new Coordinate(0.0,1.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
        l.translate(1.0, 1.0);
        Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(2.0, l.getPointN(0).getCoordinate().getY(),EPSILON);
        Assert.assertEquals(3.0, l.getPointN(1).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(4.0, l.getPointN(1).getCoordinate().getY(),EPSILON);

    }

    @Test
    public void testClone(){
        //TODO
        Point p1 = new Point(new Coordinate(0.0,1.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
        LineString copy = l.clone();
        copy.translate(1.0, 1.0);
        Assert.assertEquals(1.0, copy.getPointN(0).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(2.0, copy.getPointN(0).getCoordinate().getY(),EPSILON);
        Assert.assertEquals(3.0, copy.getPointN(1).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(4.0, copy.getPointN(1).getCoordinate().getY(),EPSILON);
        Assert.assertNotEquals(1.0, l.getPointN(0).getCoordinate().getX(),EPSILON);
        Assert.assertNotEquals(2.0, l.getPointN(0).getCoordinate().getY(),EPSILON);
        Assert.assertNotEquals(3.0, l.getPointN(1).getCoordinate().getX(),EPSILON);
        Assert.assertNotEquals(4.0, l.getPointN(1).getCoordinate().getY(),EPSILON);
    }

    @Test
    public void testGetEnvelope(){
        Point p1 = new Point(new Coordinate(0.0,1.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
        Envelope e = l.getEnvelope();
        Assert.assertEquals(0.0, e.getXmin(),EPSILON);
		Assert.assertEquals(2.0, e.getXmax(),EPSILON);
		Assert.assertEquals(1.0, e.getYmin(),EPSILON);
		Assert.assertEquals(3.0, e.getYmax(),EPSILON);
    }

}


