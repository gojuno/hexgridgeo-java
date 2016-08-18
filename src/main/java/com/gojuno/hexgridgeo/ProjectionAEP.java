package com.gojuno.hexgridgeo;

public class ProjectionAEP implements Projection {
    public ProjectionAEP() {
    }

    @Override
    public String getName() {
        return "aep";
    }

    @Override
    public com.gojuno.hexgrid.Point geoToPoint(Point geoPoint) {
        double θ = geoPoint.getLon() * (Math.PI / 180);
        double ρ = Math.PI / 2 - (geoPoint.getLat() * (Math.PI / 180));
        double x = ρ * Math.sin(θ);
        double y = -ρ * Math.cos(θ);
        return new com.gojuno.hexgrid.Point(x, y);
    }

    @Override
    public Point pointToGeo(com.gojuno.hexgrid.Point point) {
        double θ = Math.atan2(point.getX(), -point.getY());
        double ρ = point.getX() / Math.sin(θ);
        double lat = (Math.PI / 2 - ρ) / (Math.PI / 180);
        double lon = θ / (Math.PI / 180);
        return new Point(lon, lat);
    }

    @Override
    public String toString() {
        return String.format("projection{name: %s}", getName());
    }
}
