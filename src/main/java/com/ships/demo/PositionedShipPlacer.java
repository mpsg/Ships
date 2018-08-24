package com.ships.demo;

import java.util.Vector;

public class PositionedShipPlacer extends ShipPlacer {
    public PositionedShipPlacer(BoardField[][] board) {
        super(board);
    }
    public void placePositionedShips(Vector<PositionedShip> ships) {
        for (PositionedShip ship : ships) {
            int x = ship.getX();
            int y = ship.getY();
            int orientation = ship.getOrientation();
            this.placeShip(ship.getShip(), x, y, orientation);
        }
    }
}
