package com.ships.demo;

import java.util.Vector;
import java.util.Random;

public class RandomShipPlacer extends ShipPlacer {
    private Random rand = new Random();
    public RandomShipPlacer(BoardField[][] board) {
        super(board);
    }
    public void placeShipsAtRandom(Vector<Ship> ships) {
       for (Ship ship : ships) {
           boolean shipPlaced;
           do {
               int x = this.getRandomFirstCoordinate();
               int y = this.getRandomSecondCoordinate();
               shipPlaced = this.tryToPlaceShip(ship, x, y);
           } while (!shipPlaced);
        }
    }
    private boolean tryToPlaceShip(Ship ship, int x, int y) {
        boolean shipPlaced = false;
        if (this.board[x][y] == null) {
            int orientation = this.getRandomOrientation();
            int checkedOrientations = 0;
            do {
                if (this.checkIfShipWithinBoard(ship.getSize(), x, y, orientation) &&
                        this.checkIfDoesNotCollide(ship.getSize(), x, y, orientation)) {
                    this.placeShip(ship, x, y, orientation);
                    shipPlaced = true;
                } else {
                    checkedOrientations++;
                    orientation = orientation == 3 ? 0 : orientation + 1;
                }
            } while (!shipPlaced && checkedOrientations < 4);
        }
        return shipPlaced;
    }
    private int getRandomFirstCoordinate() {
        return this.randInt(this.board.length);
    }
    private int getRandomSecondCoordinate() {
        return this.randInt(this.board[0].length);
    }
    private int getRandomOrientation() {
        return this.randInt(4);
    }
    private int randInt(int bound) {
        return rand.nextInt(bound);
    }
}
