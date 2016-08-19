package com.gojuno.hexgridgeo;

import com.gojuno.hexgrid.*;
import com.gojuno.morton.Morton64;

public class HexGridGeo {
    private HexGrid hexGrid;
    private Projection projection;

    public HexGridGeo(Orientation orientation, double size, Projection projection) {
        this.hexGrid = new HexGrid(orientation, new Point(0, 0), new Point(size, size), new Morton64(2, 32));
        this.projection = projection;
    }

    public long hexToCode(Hex hex) {
        return hexGrid.hexToCode(hex);
    }

    public Hex hexFromCode(long code) {
        return hexGrid.hexFromCode(code);
    }

    public Hex hexAt(PointGeo geoPoint) {
        return hexGrid.hexAt(projection.geoToPoint(geoPoint));
    }

    public PointGeo hexCenter(Hex hex) {
        return projection.pointToGeo(hexGrid.hexCenter(hex));
    }

    public PointGeo[] hexCorners(Hex hex) {
        Point[] points = hexGrid.hexCorners(hex);
        PointGeo[] geoPoints = new PointGeo[points.length];
        for (int i = 0; i < points.length; i++) {
            geoPoints[i] = projection.pointToGeo(points[i]);
        }
        return geoPoints;
    }

    public Hex[] hexNeighbors(Hex hex, int layers) {
        return hexGrid.hexNeighbors(hex, layers);
    }

    public Region createRegion(PointGeo[] geometry) {
        Point[] points = new Point[geometry.length];
        for (int i = 0; i < geometry.length; i++) {
            points[i] = this.projection.geoToPoint(geometry[i]);
        }
        return hexGrid.createRegion(points);
    }

    @Override
    public String toString() {
        return String.format("hexgrid_geo{hexgrid: %s, projection: %s}", hexGrid.toString(), projection.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!HexGridGeo.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        HexGridGeo other = (HexGridGeo)obj;

        return other.hexGrid.equals(hexGrid) && other.projection.equals(projection);
    }
}
