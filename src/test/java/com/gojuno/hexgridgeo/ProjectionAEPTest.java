package com.gojuno.hexgridgeo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionAEPTest {
    @Test
    public void testSimple() {
        Projection projection = new ProjectionAEP();
        Point geoPoint = new Point(-73.0, 40.0);
        com.gojuno.hexgrid.Point point = projection.geoToPoint(geoPoint);
        assertEquals(-0.83453, point.getX(), 0.00001);
        assertEquals(-0.25514, point.getY(), 0.00001);
        Point recodedGeoPoint = projection.pointToGeo(point);
        assertEquals(geoPoint.getLon(), recodedGeoPoint.getLon(), 0.00001);
        assertEquals(geoPoint.getLat(), recodedGeoPoint.getLat(), 0.00001);
    }
}