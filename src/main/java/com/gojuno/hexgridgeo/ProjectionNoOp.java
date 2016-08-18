package com.gojuno.hexgridgeo;

public class ProjectionNoOp implements Projection {
    public ProjectionNoOp() {
    }

    @Override
    public String getName() {
        return "noop";
    }

    @Override
    public com.gojuno.hexgrid.Point geoToPoint(Point geoPoint) {
        return new com.gojuno.hexgrid.Point(geoPoint.getLon(), geoPoint.getLat());
    }

    @Override
    public Point pointToGeo(com.gojuno.hexgrid.Point point) {
        return new Point(point.getX(), point.getY());
    }

    @Override
    public String toString() {
        return String.format("projection{name: %s}", getName());
    }
}
