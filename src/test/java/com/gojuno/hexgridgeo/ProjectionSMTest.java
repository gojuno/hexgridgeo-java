package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionSMTest {
    @Test
    public void testSimple() {
        PointGeo geoPoint = new PointGeo(-73.0, 40.0);
        Point point = ProjectionSM.INSTANCE.geoToPoint(geoPoint);
        assertEquals(-8126322.82791, point.getX(), 0.00001);
        assertEquals(4865942.27950, point.getY(), 0.00001);
        PointGeo recodedGeoPoint = ProjectionSM.INSTANCE.pointToGeo(point);
        assertEquals(geoPoint.getLon(), recodedGeoPoint.getLon(), 0.00001);
        assertEquals(geoPoint.getLat(), recodedGeoPoint.getLat(), 0.00001);
    }
}