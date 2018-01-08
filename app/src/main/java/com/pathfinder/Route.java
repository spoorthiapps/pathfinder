package com.pathfinder;

/**
 * Created by Spoorthi P on 12/21/17.
 */

public class Route {

    private Coordinate coordinates;
    private int value;

    public Route(Coordinate coordinates, int value) {
        this.coordinates = coordinates;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }
}
