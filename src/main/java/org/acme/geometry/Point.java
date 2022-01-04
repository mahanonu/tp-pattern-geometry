package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class Point extends AbstractGeometry{

    private Coordinate coordinate;
    private List<GeometryListener> listeners;


    public Point(){
        this.coordinate = new Coordinate();
        this.listeners = new ArrayList<GeometryListener>();
    }

    public Point(Coordinate coordinate){
        if (coordinate == null){
            this.coordinate = new Coordinate();
        } else {
            this.coordinate = coordinate;
        }
        this.listeners = new ArrayList<GeometryListener>();
    }
    
    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    @Override
    public String getType(){
        return "Point";
    }

    @Override
    public boolean isEmpty(){
        return this.coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy){
        double x = this.coordinate.getX();
        double y = this.coordinate.getY();
        Coordinate newcoord = new Coordinate(x+dx,y+dy);
        this.coordinate = newcoord;
        this.triggerChange();
    }
    

    @Override
    public Point clone(){
        Coordinate coordcopy =  this.getCoordinate();
        return new Point(coordcopy);
    }
    
    @Override
    public Envelope getEnvelope(){
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(coordinate);
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


