package com.gojuno.hexgridgeo;

public interface Projection {
    String getName();
    com.gojuno.hexgrid.Point geoToPoint(Point geoPoint);
    Point pointToGeo(com.gojuno.hexgrid.Point point);
}
