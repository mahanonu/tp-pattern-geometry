package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

public class LineString extends AbstractGeometry{

    private List<Point> points;
    private List<GeometryListener> listeners;

    public LineString(){
        this.points = new ArrayList<Point>();
        this.listeners = new ArrayList<GeometryListener>();
    }

    public LineString(List<Point> points){
        if (points == null){
            this.points = new ArrayList<Point>();
        } else {
            this.points = points;
        }
        this.listeners = new ArrayList<GeometryListener>();
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
        this.triggerChange();
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

    @Override
    public Envelope getEnvelope(){
        EnvelopeBuilder builder = new EnvelopeBuilder();
        for (Point point : points) {
            builder.insert(point.getCoordinate());
        }
        return builder.build();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);        
    }

    @Override
    public String asText() {
        WktVisitor visitor = new WktVisitor();
        visitor.visit(this);
        return visitor.getResult();
    }

    @Override
    public void addListener(GeometryListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void triggerChange() {
        for (GeometryListener geometryListener : listeners) {
            geometryListener.onChange(this);
        }
    }
}
