package com.ships.demo;

import java.util.Vector;

public abstract class ShipPlacer {
    private BoardField[][] board;
    public ShipPlacer() {};
    public ShipPlacer(BoardField[][] board) {
        this.board = board;
    };
}
