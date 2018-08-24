package com.ships.demo;

public abstract class ShipPlacer {
    protected BoardField[][] board;
    public ShipPlacer(BoardField[][] board) {
        this.board = board;
    }
    protected void placeShip(Ship ship, int x, int y, int orientation) {
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
    protected boolean checkIfShipWithinBoard(int shipSize, int shipX, int shipY, int shipOrientation) {
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
    protected boolean checkIfDoesNotCollide(int shipSize, int shipX, int shipY, int shipOrientation) {
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
            fieldsToCheck--;
        }
        return true;
    }
}
