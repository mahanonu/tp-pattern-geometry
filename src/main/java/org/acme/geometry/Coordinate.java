package org.acme.geometry;

public class Coordinate {
    final private double x;
    final private double y;

    public Coordinate(){
        this.x = Double.NaN;
        this.y = Double.NaN;
    }

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty(){
        return Double.isNaN(this.x) || Double.isNaN(this.y);
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}
