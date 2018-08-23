package com.ships.demo;

import java.util.Vector;

public class Board {
    private BoardField[][] board;
    private Vector<Ship> ships;
    public Board(int size) {
        this.board = new BoardField[size][size];
    }
    public void insertShipsAtRandom(Vector<Ship> ships) {
        RandomShipPlacer shipPlacer = new RandomShipPlacer(this.board);
        shipPlacer.placeShipsAtRandom(ships);
    }
    public void insertShips(Vector<PositionedShip> positionedShips) {
        PositionedShipPlacer shipPlacer = new PositionedShipPlacer(this.board);
        shipPlacer.placePositionedShips(positionedShips);
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
