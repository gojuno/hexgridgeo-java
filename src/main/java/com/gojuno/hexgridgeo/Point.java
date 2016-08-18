package com.gojuno.hexgridgeo;

public class Point {
    private double lon;
    private double lat;

    public Point(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return String.format("point{lon: %f, lat: %f}", lon, lat);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Point.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        Point other = (Point)obj;

        return other.lon == lon && other.lat == lat;
    }
}
