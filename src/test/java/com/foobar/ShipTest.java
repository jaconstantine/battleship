package com.foobar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jconstan on 3/22/16.
 */
public class ShipTest {

    @Test
    public void testShip() {
        Ship s = new Ship(3, new Coordinate(1, 1));
        assertNotNull("ship should not be null", s);
        assertEquals("ship should have no damage", (long) 0, (long) s.countDamage());

        s.recordDamage(0);
        assertEquals("ship should have damage of 1", (long) 1, (long) s.countDamage());

        s.recordDamage(1);
        assertEquals("ship should have damage of 2", (long) 2, (long) s.countDamage());
        assertFalse("ship should not yet be sunk", s.isSunk());

        s.recordDamage(2);
        assertEquals("ship should have damage of 3", (long) 3, (long) s.countDamage());
        assertTrue("ship should be sunk", s.isSunk());

    }
}
