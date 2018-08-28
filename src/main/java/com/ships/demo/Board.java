package com.ships.demo;

import java.util.ArrayList;

public class Board {
    private BoardField[][] board;
    private ArrayList<Ship> ships;
    Board(int size) {
        this.board = new BoardField[size][size];
    }
    void insertShipsAtRandom(ArrayList<Ship> ships) {
        RandomShipPlacer shipPlacer = new RandomShipPlacer(this.board);
        shipPlacer.placeShipsAtRandom(ships);
    }
    public void insertShips(ArrayList<PositionedShip> positionedShips) {
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
    @Override
    public String toString() {
        StringBuilder strBldr = new StringBuilder();
        strBldr.append("  ");
        for (int i = 0; i < this.board.length; i++) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(i);
            tmp.append(' ');
            tmp.setLength(2);
            strBldr.append(tmp);
        }
        strBldr.append('\n');
        for (int i = 0; i < this.board.length; i++) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(i);
            tmp.append(' ');
            tmp.setLength(2);
            strBldr.append(tmp);
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j] == null) {
                    strBldr.append("  ");
                } else {
                    strBldr.append("X ");
                }
            }
            strBldr.append('\n');
        }
        return strBldr.toString();
    }
}
