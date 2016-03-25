package com.company;

/**
 * Created by jconstan on 3/21/16.
 */
public class Coordinate {
    Integer x;
    Integer y;

    Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        return other != null
                && other instanceof Coordinate
                && this.x == ((Coordinate)other).x
                && this.y == ((Coordinate)other).y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
        return hash;
    }
}
