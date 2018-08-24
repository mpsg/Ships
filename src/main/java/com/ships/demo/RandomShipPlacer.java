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
    private void placeShip(Ship ship, int x, int y, int orientation) {
        this.board[x][y] = new BoardField(ship);
        int fieldsLeft = ship.getSize() - 1;
        while (fieldsLeft > 0) {
            BoardField tmp = new BoardField(ship);
            switch (orientation) {
                case 0:
                    this.board[x+fieldsLeft][y] = tmp;
                    break;
                case 1:
                    this.board[x][y+fieldsLeft] = tmp;
                    break;
                case 2:
                    this.board[x-fieldsLeft][y] = tmp;
                    break;
                case 3:
                    this.board[x][y-fieldsLeft] = tmp;
                    break;
            }
            fieldsLeft--;
        }
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
    private boolean checkIfShipWithinBoard(int shipSize, int shipX, int shipY, int shipOrientation) {
        switch (shipOrientation) {
            case 0:
                if (shipX + shipSize - 1 < this.board.length) {
                    return true;
                } else {
                    return false;
                }
            case 1:
                if (shipY + shipSize - 1 < this.board[0].length) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (shipX - shipSize + 1 >= 0) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (shipY - shipSize + 1 >= 0) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    private boolean checkIfDoesNotCollide(int shipSize, int shipX, int shipY, int shipOrientation) {
        int fieldsToCheck = shipSize - 1;
        while (fieldsToCheck > 0) {
            switch(shipOrientation) {
                case 0:
                    if (this.board[shipX + fieldsToCheck][shipY] != null) return false;
                    break;
                case 1:
                    if (this.board[shipX][shipY + fieldsToCheck] != null) return false;
                    break;
                case 2:
                    if (this.board[shipX - fieldsToCheck][shipY] != null) return false;
                    break;
                case 3:
                    if (this.board[shipX][shipY - fieldsToCheck] != null) return false;
                    break;
            }
        }
        return true;
    }
    private int randInt(int bound) {
        return rand.nextInt(bound);
    }
}
