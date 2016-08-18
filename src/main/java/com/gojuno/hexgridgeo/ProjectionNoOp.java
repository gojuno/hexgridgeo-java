package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;

public class ProjectionNoOp implements Projection {
    public ProjectionNoOp() {
    }

    @Override
    public String getName() {
        return "noop";
    }

    @Override
    public Point geoToPoint(PointGeo geoPoint) {
        return new Point(geoPoint.getLon(), geoPoint.getLat());
    }

    @Override
    public PointGeo pointToGeo(Point point) {
        return new PointGeo(point.getX(), point.getY());
    }

    @Override
    public String toString() {
        return String.format("projection{name: %s}", getName());
    }
}
