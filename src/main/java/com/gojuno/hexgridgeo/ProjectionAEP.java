package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;

public class ProjectionAEP implements Projection {
    public ProjectionAEP() {
    }

    @Override
    public String getName() {
        return "aep";
    }

    @Override
    public Point geoToPoint(PointGeo geoPoint) {
        double θ = geoPoint.getLon() * (Math.PI / 180);
        double ρ = Math.PI / 2 - (geoPoint.getLat() * (Math.PI / 180));
        double x = ρ * Math.sin(θ);
        double y = -ρ * Math.cos(θ);
        return new Point(x, y);
    }

    @Override
    public PointGeo pointToGeo(Point point) {
        double θ = Math.atan2(point.getX(), -point.getY());
        double ρ = point.getX() / Math.sin(θ);
        double lat = (Math.PI / 2 - ρ) / (Math.PI / 180);
        double lon = θ / (Math.PI / 180);
        return new PointGeo(lon, lat);
    }

    @Override
    public String toString() {
        return String.format("projection{name: %s}", getName());
    }
}
