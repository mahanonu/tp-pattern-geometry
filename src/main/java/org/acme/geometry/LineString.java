package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

public class LineString implements Geometry{

    private List<Point> points;

    public LineString(){
        this.points = new ArrayList<Point>();
    }

    public LineString(List<Point> points){
        if (points == null){
            this.points = new ArrayList<Point>();
        } else {
            this.points = points;
        }
    }

    public int getNumPoints(){
        return this.points.size();
    }

    public Point getPointN(int n){
        return this.points.get(n);
    }

    @Override
    public String getType(){
        return "LineString";
    }

    @Override
    public boolean isEmpty(){
        return this.points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy){
        int size = this.getNumPoints();
        for (int i=0;i<size;i++){
            this.getPointN(i).translate(dx, dy);
        }
    }

    @Override
    public LineString clone(){
        int size = this.getNumPoints();
        ArrayList<Point> listcopy = new ArrayList<>();
        for (int i=0;i<size;i++){
            listcopy.add(this.getPointN(i).clone());
        }

        return new LineString(listcopy);
    }
}
