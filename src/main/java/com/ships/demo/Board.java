package com.ships.demo;

import java.util.Vector;

public class Board {
    private BoardField[][] board;
    private Vector<Ship> ships;
    public Board(int size) {
        this.board = new BoardField[size][size];
    }
    public void insertShipsAtRandom(Vector<Ship> ships) {
        //TODO implement method
    }
    //ship - the ship to be inserted; x, y - coordinates of a point at the end of the ship, origin for the orientation;
    //orientation - 0 means the ship extends to the right from the origin, 1 to the bottom, 2 to the left, 3 upwards;
    public void insertShips(Vector<PositionedShip> ships) {
        ShipPlacer shipPlacer = new ShipPlacer(this);
        shipPlacer.placeShips(ships);
    }
    //x, y - coordinates of the hit; returns 0 if it's a miss, 1 if it's a hit, 2 if the ship was hit and destroyed
    public int shootAt(int x, int y) {
        if (this.board[x][y] == null) {
            return 0;
        } else if (this.board[x][y].isShipDestroyedAfterHit()) {
            this.ships.remove(this.board[x][y].getShip());
            return 2;
        } else {
            return 1;
        }
    }
    public boolean checkIfWin() {
        if (this.ships.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
