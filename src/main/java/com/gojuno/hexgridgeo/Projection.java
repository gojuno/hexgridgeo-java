package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;

public interface Projection {
    String getName();
    Point geoToPoint(PointGeo geoPoint);
    PointGeo pointToGeo(Point point);
}
