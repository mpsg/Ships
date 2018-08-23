package com.ships.demo;

public abstract class ShipPlacer {
    protected BoardField[][] board;
    public ShipPlacer(BoardField[][] board) {
        this.board = board;
    }
}
