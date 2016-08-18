package com.gojuno.hexgridgeo;

public class PointGeo {
    private double lon;
    private double lat;

    public PointGeo(double lon, double lat) {
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
        return String.format("pointgeo{lon: %f, lat: %f}", lon, lat);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!PointGeo.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        PointGeo other = (PointGeo)obj;

        return other.lon == lon && other.lat == lat;
    }
}
