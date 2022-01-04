package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry,GeometryListener {

    private Geometry original;
    private Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = new Envelope();
        this.original.addListener(this);
    }

    @Override
    public String getType() {
        return this.original.getType();
    }

    @Override
    public boolean isEmpty() {
        return this.original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.original.translate(dx, dy);
    }

    @Override
    public Geometry clone() {
        return this.original.clone();
    }

    @Override
    public Envelope getEnvelope() {
        if (this.cachedEnvelope.isEmpty()){
            this.cachedEnvelope = this.original.getEnvelope();
            return this.cachedEnvelope;
        }else {
            return this.cachedEnvelope;
        }   
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        this.original.accept(visitor);
    }

    @Override
    public void onChange(Geometry geometry) {
        this.cachedEnvelope = geometry.getEnvelope();
    }

    @Override
    public void addListener(GeometryListener listener) {
        this.original.addListener(listener);
    }
}
