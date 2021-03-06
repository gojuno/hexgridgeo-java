package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionNoOpTest {
    @Test
    public void testSimple() {
        PointGeo geoPoint = new PointGeo(-73.0, 40.0);
        Point point = ProjectionNoOp.INSTANCE.geoToPoint(geoPoint);
        assertEquals(-73.0, point.getX(), 0.00001);
        assertEquals(40.0, point.getY(), 0.00001);
        PointGeo recodedGeoPoint = ProjectionNoOp.INSTANCE.pointToGeo(point);
        assertEquals(geoPoint.getLon(), recodedGeoPoint.getLon(), 0.00001);
        assertEquals(geoPoint.getLat(), recodedGeoPoint.getLat(), 0.00001);
    }
}