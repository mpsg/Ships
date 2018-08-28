package com.ships.demo;

abstract class ShipPlacer {
    protected BoardField[][] board;
    ShipPlacer(BoardField[][] board) {
        this.board = board;
    }
    protected void placeShip(Ship ship, int x, int y, Orientation orientation) {
        this.board[x][y] = new BoardField(ship);
        int fieldsLeft = ship.getSize() - 1;
        while (fieldsLeft > 0) {
            BoardField tmp = new BoardField(ship);
            switch (orientation) {
                case RIGHT:
                    this.board[x+fieldsLeft][y] = tmp;
                    break;
                case DOWN:
                    this.board[x][y+fieldsLeft] = tmp;
                    break;
                case LEFT:
                    this.board[x-fieldsLeft][y] = tmp;
                    break;
                case UP:
                    this.board[x][y-fieldsLeft] = tmp;
                    break;
            }
            fieldsLeft--;
        }
    }
    protected boolean checkIfShipWithinBoard(int shipSize, int shipX, int shipY, Orientation shipOrientation) {
        switch (shipOrientation) {
            case RIGHT:
                if (shipX + shipSize - 1 < this.board.length) {
                    return true;
                } else {
                    return false;
                }
            case DOWN:
                if (shipY + shipSize - 1 < this.board[0].length) {
                    return true;
                } else {
                    return false;
                }
            case LEFT:
                if (shipX - shipSize + 1 >= 0) {
                    return true;
                } else {
                    return false;
                }
            case UP:
                if (shipY - shipSize + 1 >= 0) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    protected boolean checkIfDoesNotCollide(int shipSize, int shipX, int shipY, Orientation shipOrientation) {
        int fieldsToCheck = shipSize - 1;
        while (fieldsToCheck > 0) {
            switch(shipOrientation) {
                case RIGHT:
                    if (this.board[shipX + fieldsToCheck][shipY] != null) return false;
                    break;
                case DOWN:
                    if (this.board[shipX][shipY + fieldsToCheck] != null) return false;
                    break;
                case LEFT:
                    if (this.board[shipX - fieldsToCheck][shipY] != null) return false;
                    break;
                case UP:
                    if (this.board[shipX][shipY - fieldsToCheck] != null) return false;
                    break;
            }
            fieldsToCheck--;
        }
        return true;
    }
}
