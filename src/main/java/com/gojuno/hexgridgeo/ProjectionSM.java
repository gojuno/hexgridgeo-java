package com.gojuno.hexgridgeo;

public class ProjectionSM implements Projection {
    private static final double EARTH_CIRCUMFERENCE = 40075016.685578488;
    private static final double EARTH_METERS_PER_DEGREE = 111319.49079327358;

    public ProjectionSM() {
    }

    @Override
    public String getName() {
        return "sm";
    }

    @Override
    public com.gojuno.hexgrid.Point geoToPoint(Point geoPoint) {
        double latR = geoPoint.getLat() * (Math.PI / 180);
        double x = geoPoint.getLon() * EARTH_METERS_PER_DEGREE;
        double y = Math.log(Math.tan(latR) + (1 / Math.cos(latR)));
        y = (y / Math.PI) * (EARTH_CIRCUMFERENCE / 2);
        return new com.gojuno.hexgrid.Point(x, y);
    }

    @Override
    public Point pointToGeo(com.gojuno.hexgrid.Point point) {
        double lon = point.getX() / EARTH_METERS_PER_DEGREE;
        double lat = Math.asin(Math.tanh((point.getY() / (EARTH_CIRCUMFERENCE / 2)) * Math.PI));
        lat = lat * (180 / Math.PI);
        return new Point(lon, lat);
    }

    @Override
    public String toString() {
        return String.format("projection{name: %s}", getName());
    }
}