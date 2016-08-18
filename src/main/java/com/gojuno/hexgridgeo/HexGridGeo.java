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
        return this.hexGrid.hexToCode(hex);
    }

    public Hex hexFromCode(long code) {
        return this.hexGrid.hexFromCode(code);
    }

    public Hex hexAt(PointGeo geoPoint) {
        return this.hexGrid.hexAt(this.projection.geoToPoint(geoPoint));
    }

    public PointGeo hexCenter(Hex hex) {
        return this.projection.pointToGeo(this.hexGrid.hexCenter(hex));
    }

    public PointGeo[] hexCorners(Hex hex) {
        Point[] points = this.hexGrid.hexCorners(hex);
        PointGeo[] geoPoints = new PointGeo[points.length];
        for (int i = 0; i < points.length; i++) {
            geoPoints[i] = this.projection.pointToGeo(points[i]);
        }
        return geoPoints;
    }

    public Hex[] hexNeighbors(Hex hex, int layers) {
        return this.hexGrid.hexNeighbors(hex, layers);
    }

    public Region createRegion(PointGeo[] geometry) {
        Point[] points = new Point[geometry.length];
        for (int i = 0; i < geometry.length; i++) {
            points[i] = this.projection.geoToPoint(geometry[i]);
        }
        return this.hexGrid.createRegion(points);
    }
}
