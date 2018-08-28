package com.ships.demo;

import java.util.ArrayList;

public class ShipFactory {
    private int producesShips;
    private int smallestShipSize;
    public ShipFactory(int shipsToProduce, int smallestShipSize) {
        this.producesShips = shipsToProduce;
        this.smallestShipSize = smallestShipSize;
    }
    public ArrayList<Ship> makeShips() {
        ArrayList<Ship> ships = new ArrayList<>(this.producesShips);
        int shipsLeft = this.producesShips;
        while (shipsLeft > 0) {
            int shipSize = shipsLeft + this.smallestShipSize - 1;
            ships.add(new Ship(shipSize));
            shipsLeft--;
        }
        return ships;
    }
}
