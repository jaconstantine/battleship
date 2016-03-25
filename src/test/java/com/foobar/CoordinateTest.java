package com.foobar;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by jconstan on 3/24/16.
 */
public class CoordinateTest {

    @Test
    public void testCoord() {
        Coordinate c1 = new Coordinate(0, 1);
        Coordinate c2 = new Coordinate(0, 2);
        Coordinate c3 = new Coordinate(0, 1);
        Coordinate c4 = new Coordinate(1, 1);

        assertTrue(c1.equals(c3));
        assertFalse(c1.equals(c2));
        assertFalse(c2.equals(c3));
        assertFalse(c1.equals(c4));
    }
}
