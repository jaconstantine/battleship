package com.company;

import org.junit.Before;
import org.junit.Test;

import static com.company.Ship.hitShips;
import static org.junit.Assert.*;



/**
 * Created by jconstan on 3/21/16.
 */
public class BoardTest {

    Board b;

    @Before
    public void setupBoard() {
        b = new Board();
    }

    @Test
    public void testGoodConfig() {
        Integer[] conf = {-1, 0, 1, 2, -1};
        Boolean ok = true;


        try {
            b.init(conf);
        } catch (boardException e) {
            System.err.println("init failed: " + e.message);
            ok = false;
        }
        assertTrue("init failed - ok is false", ok);

        Ship[] ships = b.getShips();
        assertNotNull("there should be 3 ships", ships);
        assertEquals("there should be 3 ships", 3, ships.length);

        assertFalse("should be miss", hitShips(ships, new Coordinate(0, 0)).isPresent());
        assertFalse("should be miss", hitShips(ships, new Coordinate(0, 1)).isPresent());
        assertFalse("should be miss", hitShips(ships, new Coordinate(0, 2)).isPresent());
        assertFalse("should be miss", hitShips(ships, new Coordinate(0, 3)).isPresent());
        assertFalse("should be miss", hitShips(ships, new Coordinate(0, 4)).isPresent());

        assertTrue("should be hit", (hitShips(ships, new Coordinate(1, 0)).get() > -1));
        assertTrue("should be hit", (hitShips(ships, new Coordinate(1, 1)).get() > -1));
        assertTrue("should be hit", (hitShips(ships, new Coordinate(1, 2)).get() > -1));
        assertFalse("should be miss 1,3", hitShips(ships, new Coordinate(1, 3)).isPresent());
        assertFalse("should be miss 1,4", hitShips(ships, new Coordinate(1, 4)).isPresent());

        assertFalse("should be miss 2,0", hitShips(ships, new Coordinate(2, 0)).isPresent());
        assertTrue("should be hit 2,1", (hitShips(ships, new Coordinate(2, 1)).get() > -1));
        assertTrue("should be hit 2,2", (hitShips(ships, new Coordinate(2, 2)).get() > -1));
        assertTrue("should be hit 2,3", (hitShips(ships, new Coordinate(2, 3)).get() > -1));
        assertFalse("should be miss 2,4", hitShips(ships, new Coordinate(2, 4)).isPresent());
    }

    @Test
    public void testDoMove() {

        Integer[] conf = {-1, 0, 1, 2, -1};
        try {
            b.init(conf);
        } catch (boardException e) {
            System.err.println("init failed: " + e.message);
        }

        Ship[] ships = b.getShips();
        assertNotNull("there should be 3 ships", ships);
        assertEquals("there should be 3 ships", 3, ships.length);

        assertEquals("should be MISS", Board.moveResult.MISS, b.doMove(new Coordinate(0, 0)));
        assertEquals("should be ALREADY_PLAYED", Board.moveResult.ALREADY_PLAYED, b.doMove(new Coordinate(0, 0)));

        assertEquals("should be HIT", Board.moveResult.HIT, b.doMove(new Coordinate(1,0)));
        assertEquals("should be HIT", Board.moveResult.HIT, b.doMove(new Coordinate(1,1)));
        assertEquals("should be SINK", Board.moveResult.SINK, b.doMove(new Coordinate(1,2)));

        assertEquals("should be HIT", Board.moveResult.HIT, b.doMove(new Coordinate(2,1)));
        assertEquals("should be HIT", Board.moveResult.HIT, b.doMove(new Coordinate(2,2)));
        assertEquals("should be SINK", Board.moveResult.SINK, b.doMove(new Coordinate(2,3)));

        assertEquals("should be HIT", Board.moveResult.HIT, b.doMove(new Coordinate(3,2)));
        assertEquals("should be HIT", Board.moveResult.HIT, b.doMove(new Coordinate(3,3)));
        assertEquals("should be ALL_SUNK", Board.moveResult.ALL_SUNK, b.doMove(new Coordinate(3,4)));
    }
}

