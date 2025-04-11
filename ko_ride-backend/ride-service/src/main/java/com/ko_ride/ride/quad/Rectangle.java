package com.ko_ride.ride.quad;

public class Rectangle {
    private double lat; // center latitude
    private double lon; // center longitude
    private double halfLatSpan;
    private double halfLonSpan;

    public Rectangle(double lat, double lon, double halfLatSpan, double halfLonSpan) {
        this.lat = lat;
        this.lon = lon;
        this.halfLatSpan = halfLatSpan;
        this.halfLonSpan = halfLonSpan;
    }

    public boolean contains(Point point) {
        return (point.getLon() >= lon - halfLonSpan &&
                point.getLon() <= lon + halfLonSpan &&
                point.getLat() >= lat - halfLatSpan &&
                point.getLat() <= lat + halfLatSpan);
    }

    public boolean intersects(Rectangle range) {
        return !(range.lon - range.halfLonSpan > lon + halfLonSpan ||
                range.lon + range.halfLonSpan < lon - halfLonSpan ||
                range.lat - range.halfLatSpan > lat + halfLatSpan ||
                range.lat + range.halfLatSpan < lat - halfLatSpan);
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getHalfLatSpan() {
        return halfLatSpan;
    }

    public double getHalfLonSpan() {
        return halfLonSpan;
    }
}
