package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    public StringBuilder buffer;

    public WktVisitor(){
        this.buffer =new StringBuilder();
    }

    @Override
    public void visit(Point point) {
        if (point.isEmpty()){
            this.buffer.append("geometry type not supported");
        } else {
            this.buffer.append("POINT(");
            this.buffer.append(point.getCoordinate().getX());
            this.buffer.append(" ");
            this.buffer.append(point.getCoordinate().getY());
            this.buffer.append(")");
        }
        
    }

    @Override
    public void visit(LineString lineString) {
        int size = lineString.getNumPoints();
        this.buffer.append("LINESTRING(");
        for (int i=0;i<size;i++){
            this.buffer.append(lineString.getPointN(i).getCoordinate().getX());
            this.buffer.append(" ");
            this.buffer.append(lineString.getPointN(i).getCoordinate().getY());
            this.buffer.append(",");
        }
        this.buffer.deleteCharAt(buffer.length()-1);
        this.buffer.append(")");
    }
 
    public String getResult(){
        return this.buffer.toString();
    }
}
