package com.ships.demo;

import java.util.Vector;

public class ShipFactory {
    private int producesShips;
    private int shipsLeft;
    public ShipFactory(int shipsToProduce) {
        this.producesShips = shipsToProduce;
    }
    public Vector<Ship> makeShips() {
        Vector<Ship> ships = new Vector<>(this.producesShips);
        this.shipsLeft = this.producesShips;
        while (this.shipsLeft > 0) {
            int shipSize = this.shipsLeft + 2;
            ships.add(new Ship(shipSize));
            this.shipsLeft--;
        }
        return ships;
    }
}
