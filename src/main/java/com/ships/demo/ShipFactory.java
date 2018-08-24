package com.ships.demo;

import java.util.Vector;

public class ShipFactory {
    private int producesShips;
    private int smallestShipSize;
    public ShipFactory(int shipsToProduce, int smallestShipSize) {
        this.producesShips = shipsToProduce;
        this.smallestShipSize = smallestShipSize;
    }
    public Vector<Ship> makeShips() {
        Vector<Ship> ships = new Vector<>(this.producesShips);
        int shipsLeft = this.producesShips;
        while (shipsLeft > 0) {
            int shipSize = shipsLeft + this.smallestShipSize - 1;
            ships.add(new Ship(shipSize));
            shipsLeft--;
        }
        return ships;
    }
}
