package com.gojuno.hexgridgeo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionSMTest {
    @Test
    public void testSimple() {
        Projection projection = new ProjectionSM();
        Point geoPoint = new Point(-73.0, 40.0);
        com.gojuno.hexgrid.Point point = projection.geoToPoint(geoPoint);
        assertEquals(-8126322.82791, point.getX(), 0.00001);
        assertEquals(4865942.27950, point.getY(), 0.00001);
        Point recodedGeoPoint = projection.pointToGeo(point);
        assertEquals(geoPoint.getLon(), recodedGeoPoint.getLon(), 0.00001);
        assertEquals(geoPoint.getLat(), recodedGeoPoint.getLat(), 0.00001);
    }
}