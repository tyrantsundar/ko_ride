package com.ko_ride.ride.quad;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    private final QuadNode root;

    public QuadTree(Rectangle boundary, int capacity) {
        this.root = new QuadNode(boundary, capacity);
    }

    public boolean insert(Point point) {
        return root.insert(point);
    }

    public List<Point> query(Rectangle range) {
        List<Point> found = new ArrayList<>();
        root.query(range, found);
        return found;
    }

    // Future methods
    // public boolean remove(Point point) { ... }
    // public void update(Point old, Point updated) { ... }
}
