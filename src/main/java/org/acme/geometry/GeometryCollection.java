package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {

    private List<Geometry> geometries;
    
    public GeometryCollection(){
        this.geometries = new ArrayList<Geometry>();
    }


    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void translate(double dx, double dy) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addListener(GeometryListener listener) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Geometry clone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String asText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Envelope getEnvelope() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void triggerChange() {
        // TODO Auto-generated method stub
        
    }
    
}
