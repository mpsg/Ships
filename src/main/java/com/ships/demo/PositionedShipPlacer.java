package com.ships.demo;

import java.util.ArrayList;

class PositionedShipPlacer extends ShipPlacer {
    PositionedShipPlacer(BoardField[][] board) {
        super(board);
    }
    void placePositionedShips(ArrayList<PositionedShip> ships) {
        for (PositionedShip ship : ships) {
            int x = ship.getX();
            int y = ship.getY();
            int orientation = ship.getOrientation();
            this.placeShip(ship.getShip(), x, y, orientation);
        }
    }
}
