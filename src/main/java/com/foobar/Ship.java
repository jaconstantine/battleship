package com.foobar;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by jconstan on 3/2/16.
 */
public class Ship {
    Coordinate loc;
    private Boolean[] damage;
    private Integer size = 0;

    Ship(Integer size, Coordinate l) {
        this.size = size;
        damage = new Boolean[size];
        Arrays.fill(damage, false);
        loc=l;
    }

    public Integer countDamage() {
        Integer sum = 0;
        for(boolean b : damage) {
            sum += b ? 1 : 0;
        }
        return sum;
    }

    public Boolean isSunk() {
        if (countDamage() == size) return true;
        return false;
    }

    public static Optional<Integer> hitShips(Ship[] ships, Coordinate c) {
        for(int i = 0; i < ships.length; i++) {
            if (c.x != ships[i].loc.x) continue;
            if (c.y >= ships[i].loc.y && c.y <= (ships[i].loc.y + ships[i].size - 1)) {
                // record the damage
                // System.err.println("damage to ship " + i + " offset " + (c.y - ships[i].loc.y));
                ships[i].recordDamage(c.y - ships[i].loc.y);
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static Boolean isHit(Ship[] ships, Coordinate c) {
        for(int i = 0; i < ships.length; i++) {
            if (c.x != ships[i].loc.x) continue;
            if (c.y >= ships[i].loc.y && c.y <= (ships[i].loc.y + ships[i].size - 1)) return true;
        }
        return false;
    }

    public void recordDamage(Integer i) {
        if (i < size) {
            damage[i] = true;
        }
    }

    public static Boolean allSunk(Ship[] ships) {
        for (Ship s : ships) {
            if (s.isSunk() == false) return false;
        }
        return true;
    }
}
