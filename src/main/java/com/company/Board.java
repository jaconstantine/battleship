package com.company;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.company.Ship.allSunk;
import static com.company.Ship.hitShips;

/**
 * Created by jconstan on 3/21/16.
 */
public class Board {
    // this class represents one board in the game of battleship
    final private Integer bsize = 5;  // dimension of square board is bsize x bsize
    final private Integer nships = 3; // board must have this many ships
    final private Integer shipSize = 3;

    private Set<Coordinate> history = new HashSet<Coordinate>(bsize * (bsize/2));
    private Ship[] ships = new Ship[nships];

    public void init(Integer[] in) throws boardException {
        Integer shipIndex = 0;
        // initialize the board
        for(Integer i = 0; i < bsize; i++) {
           if (in[i] < -1 || in[i] > (bsize - shipSize)) throw new boardException("ship position won't work");
            if (in[i] == -1) continue;
            if (shipIndex > shipSize - 1) throw new boardException("too many ships. only " + nships + " are allowed");
            ships[shipIndex] = new Ship(shipSize, new Coordinate(i, in[i]));
            shipIndex++;
        }
        if (shipIndex != nships) throw new boardException("wrong number of ships. Got: " + shipIndex + ", should be " + nships);
    }

    public enum moveResult {
        HIT,
        MISS,
        ALREADY_PLAYED,
        SINK,
        ALL_SUNK
    }

    public moveResult doMove(Coordinate m) {
        // have we played this move already>
        if (history.contains(m) == true) return moveResult.ALREADY_PLAYED;
        history.add(m);

        Optional<Integer> i = hitShips(ships, m);
        if (i.isPresent()) {
            // check if ships[i] is sunk
            if (ships[i.get()].isSunk() == true) {
                // see if all the ships are sunk
                if (allSunk(ships) == true) return moveResult.ALL_SUNK;
                return moveResult.SINK;
            }
            return moveResult.HIT;
        }
        else return moveResult.MISS;
    }

    public Ship[] getShips() {
        return ships;
    }

    public Integer getBsize() { return bsize; }
}
