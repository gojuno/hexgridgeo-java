package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionAEPTest {
    @Test
    public void testSimple() {
        Projection projection = new ProjectionAEP();
        PointGeo geoPoint = new PointGeo(-73.0, 40.0);
        Point point = projection.geoToPoint(geoPoint);
        assertEquals(-0.83453, point.getX(), 0.00001);
        assertEquals(-0.25514, point.getY(), 0.00001);
        PointGeo recodedGeoPoint = projection.pointToGeo(point);
        assertEquals(geoPoint.getLon(), recodedGeoPoint.getLon(), 0.00001);
        assertEquals(geoPoint.getLat(), recodedGeoPoint.getLat(), 0.00001);
    }
}