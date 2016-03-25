## the game of battleship

Here are the classes that model the game of battleship.

#### Coordinate

A class to hold x,y values.  Overrides both hashCode() and equals() so that hashSet can check for equivalence.
  
#### Ship

A class that represents a ship.  Constructor takes a Coordinate and an Integer size.  All ship are vertically oriented.  A ship maintains state of damage done to it.  
  
Methods

* Integer countDamage() - measures how many elements of a ship are damaged
* Boolean isHit(Coordinate c) - true if this coordinate would result in a hit on this ship
* Boolean isSunk() - returns true if this ship has been sunk
* static Boolean allSunk(Ship[] ships) - returns true if all ships have been sunk
* static Optional<Integer> hitShips(Ship[] ships, Coordinate c) - process a move and returns an index into the array of ships if a ship is hit.  Registers the damage done by the move.
    
#### Board

Class that represents a game board and the interactions with it. This class controls the board size, the number of ships per board, and ths size of the ships. A board maintains a set of moves that have been played against it in order to detect that a move has already been played.

Methods

* init(Integer[] positions) - sets up a board with the initial ship positions.  Throws an exception if the array of ship locations does not pass constraints. 
* moveResult doMove(Coordinate c) - processes a game move and returns an enum: moveResult - which can have the values of: HIT, MISS, ALREADY_PLAYED, SINK, ALL_SUNK

