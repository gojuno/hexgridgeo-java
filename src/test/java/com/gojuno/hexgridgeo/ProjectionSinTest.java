package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionSinTest {
    @Test
    public void testSimple() {
        PointGeo geoPoint = new PointGeo(-73.0, 40.0);
        Point point = ProjectionSin.INSTANCE.geoToPoint(geoPoint);
        assertEquals(9124497.47463, point.getX(), 0.00001);
        assertEquals(4452779.63173, point.getY(), 0.00001);
        PointGeo recodedGeoPoint = ProjectionSin.INSTANCE.pointToGeo(point);
        assertEquals(geoPoint.getLon(), recodedGeoPoint.getLon(), 0.00001);
        assertEquals(geoPoint.getLat(), recodedGeoPoint.getLat(), 0.00001);
    }
}