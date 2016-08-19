package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;

public class ProjectionSin implements Projection {
    public static final Projection INSTANCE = new ProjectionSin();
    private static final double EARTH_CIRCUMFERENCE = 40075016.685578488;

    private ProjectionSin() {
    }

    @Override
    public String getName() {
        return "sin";
    }

    @Override
    public Point geoToPoint(PointGeo geoPoint) {
        double λ = (geoPoint.getLon() + 180) * (Math.PI / 180);
        double φ = geoPoint.getLat() * (Math.PI / 180);
        double x = (λ * Math.cos(φ)) * ((EARTH_CIRCUMFERENCE / 2) / Math.PI);
        double y = φ * ((EARTH_CIRCUMFERENCE / 2) / Math.PI);
        return new Point(x, y);
    }

    @Override
    public PointGeo pointToGeo(Point point) {
        double φ = point.getY() / ((EARTH_CIRCUMFERENCE / 2) / Math.PI);
        double λ = point.getX() / (Math.cos(φ) * ((EARTH_CIRCUMFERENCE / 2) / Math.PI));
        double lon = (λ / (Math.PI / 180)) - 180;
        double lat = φ / (Math.PI / 180);
        return new PointGeo(lon, lat);
    }

    @Override
    public String toString() {
        return String.format("projection{name: %s}", getName());
    }
}
