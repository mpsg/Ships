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
    //returns true if the ship can be inserted in the given position, false if the operation failed
    public boolean insertShip(Ship ship, int x, int y, int orientation) {
        //TODO implement method
        return true;
    }
    //x, y - coordinates of the hit; returns 0 if it's a miss, 1 if it's a hit, 2 if the ship was hit and destroyed
    public int shootAt(int x, int y) {
        if (board[x][y] == null) {
            return 0;
        } else if (!this.board[x][y].makeHit()) {
            this.ships.remove(this.board[x][y]);
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
