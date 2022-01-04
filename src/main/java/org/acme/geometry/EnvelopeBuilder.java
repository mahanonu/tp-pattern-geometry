package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor{
    
    private List<Coordinate> coordinates;

    public EnvelopeBuilder(){
        this.coordinates = new ArrayList<>();   
    };

    public void insert(Coordinate coordinate){
        this.coordinates.add(coordinate);
    }


    public Envelope build(){
        double minX = 10E9;
        double minY = 10E9;
        double maxX = 0;
        double maxY = 0;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getX()<minX){
                minX = coordinate.getX();
            } 
            if (coordinate.getX()>maxX){
                maxX = coordinate.getX();
            }
            if (coordinate.getY()<minY){
                minY = coordinate.getY();
            }
            if (coordinate.getY()>maxY){
                maxY = coordinate.getY();
            }
        }
        return new Envelope(new Coordinate(minX,minY),new Coordinate(maxX,maxY));
    }

    @Override
    public void visit(Point point) {
        this.insert(point.getCoordinate());        
    }

    @Override
    public void visit(LineString lineString) {
        int size = lineString.getNumPoints();
        for (int i=0;i<size;i++){
            this.insert(lineString.getPointN(i).getCoordinate());
        }
    }
}
