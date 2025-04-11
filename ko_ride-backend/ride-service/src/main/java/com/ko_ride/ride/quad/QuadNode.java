package com.ko_ride.ride.quad;

import java.util.ArrayList;
import java.util.List;

public class QuadNode {
    private final Rectangle boundary;
    private final int capacity;
    private final List<Point> points;
    private boolean divided;

    private QuadNode northWest;
    private QuadNode northEast;
    private QuadNode southWest;
    private QuadNode southEast;

    public QuadNode(Rectangle boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.points = new ArrayList<>();
        this.divided = false;
    }

    public boolean insert(Point point) {
        if (!boundary.contains(point)) {
            return false; // Out of bounds
        }

        // If already subdivided, directly try to insert into children
        if (divided) {
            return addIntoChild(point);
        }

        // Only add to points if not divided yet
        if (points.size() < capacity) {
            points.add(point);
            return true;
        }

        // Node full and not yet divided, so divide and push all points down
        subdivide();

        // Re-insert current point into new children
        return addIntoChild(point);
    }

    private boolean addIntoChild(Point point){
        return (
                northWest.insert(point) ||
                        northEast.insert(point) ||
                        southWest.insert(point) ||
                        southEast.insert(point)
        );
    }

    private void subdivide() {
        double lat = boundary.getLat();
        double lon = boundary.getLon();
        double hLat = boundary.getHalfLatSpan() / 2;
        double hLon = boundary.getHalfLonSpan() / 2;

        northWest = new QuadNode(new Rectangle(lat + hLat, lon - hLon, hLat, hLon), capacity);
        northEast = new QuadNode(new Rectangle(lat + hLat, lon + hLon, hLat, hLon), capacity);
        southWest = new QuadNode(new Rectangle(lat - hLat, lon - hLon, hLat, hLon), capacity);
        southEast = new QuadNode(new Rectangle(lat - hLat, lon + hLon, hLat, hLon), capacity);

        // Redistribute existing points
        List<Point> oldPoints = new ArrayList<>(points);
        points.clear(); // Parent becomes just a router
        for (Point p : oldPoints) {
            if (!(
                    northWest.insert(p) ||
                            northEast.insert(p) ||
                            southWest.insert(p) ||
                            southEast.insert(p)
            )) {
                System.err.println("Failed to reinsert point: " + p);
            }
        }
        divided = true;
    }


    public void query(Rectangle range, List<Point> found) {
        if (!boundary.intersects(range)) {
            return;
        }

        for (Point point : points) {
            if (range.contains(point)) {
                found.add(point);
            }
        }

        if (divided) {
            northWest.query(range, found);
            northEast.query(range, found);
            southWest.query(range, found);
            southEast.query(range, found);
        }
    }
}
