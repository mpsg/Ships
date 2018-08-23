package com.ships.demo;

public class BoardField {
    private boolean fieldDiscovered = false;
    private Ship ship;
    public BoardField(Ship ship) {
        this.ship = ship;
    }
    //returns true if the ship to which this field belongs was destroyed
    public boolean isShipDestroyedAfterHit() {
        if (!this.fieldDiscovered) {
            this.fieldDiscovered = true;
            return this.ship.hit();
        } else {
            //TODO raise some exception
            return false;
        }
    }
    public Ship getShip() {
        return this.ship;
    }
}
