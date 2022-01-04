package org.acme.geometry;

import java.text.MessageFormat;

public class WktWriter {
    
    public WktWriter(){};

    public String write(Geometry geometry){
        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            return "POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")";
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString)geometry;
            String wkt = "LINESTRING(";
            int size = lineString.getNumPoints();
            for (int i=0;i<size;i++){
                wkt +=  lineString.getPointN(i).getCoordinate().getX() + " ";
                wkt += lineString.getPointN(i).getCoordinate().getY() + ",";
            }
            return wkt.substring(0,wkt.length()-1)+")";
        }else{
            throw new RuntimeException("geometry type not supported");
        }
    }
}
