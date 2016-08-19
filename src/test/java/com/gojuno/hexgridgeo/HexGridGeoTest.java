package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.Orientation;
import org.junit.Test;

import static org.junit.Assert.*;

public class HexGridGeoTest {
    @Test
    public void testSimple() {
        HexGridGeo grid = new HexGridGeo(Orientation.FLAT, 500, ProjectionSM.INSTANCE);
        PointGeo[] corners = grid.hexCorners(grid.hexAt(new PointGeo(-73.0, 40.0)));
        PointGeo[] expectedCorners = new PointGeo[]{
                new PointGeo(-72.99485, 39.99877), new PointGeo(-72.99710, 40.00175),
                new PointGeo(-73.00159, 40.00175), new PointGeo(-73.00384, 39.99877),
                new PointGeo(-73.00159, 39.99579), new PointGeo(-72.99710, 39.99579)};
        assertEquals(expectedCorners.length, corners.length);
        for (int i = 0; i < corners.length; i++) {
            assertEquals(expectedCorners[i].getLon(), corners[i].getLon(), 0.00001);
            assertEquals(expectedCorners[i].getLat(), corners[i].getLat(), 0.00001);
        }
    }
}