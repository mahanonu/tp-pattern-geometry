package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class LogGeometryVisitorTest {

    public static Coordinate c1 = new Coordinate(0.0,1.0);
    public static Coordinate c2 = new Coordinate(2.0,3.0);
	public static Point p1 = new Point(c1);
    public static Point p2 = new Point(c2);


    @Test
    public void testVisitPoint() throws UnsupportedEncodingException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        p1.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("Je suis un point avec x=0.0 et y=1.0", result);
    }

    @Test
    public void testVisitLineString() throws UnsupportedEncodingException{
        ArrayList<Point> al = new ArrayList<>();
        al.add(p1);
        al.add(p2);
		LineString l = new LineString(al);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        l.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("Je suis une polyligne définie par 2 points", result);
        
    }
}
