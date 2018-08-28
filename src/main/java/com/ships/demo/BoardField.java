package com.ships.demo;

class BoardField {
    private boolean fieldDiscovered = false;
    private Ship ship;
    BoardField(Ship ship) {
        this.ship = ship;
    }
    //returns true if the ship to which this field belongs was destroyed
    boolean isShipDestroyedAfterHit() {
        if (!this.fieldDiscovered) {
            this.fieldDiscovered = true;
            return this.ship.hit();
        } else {
            //TODO raise some exception
            return false;
        }
    }
    Ship getShip() {
        return this.ship;
    }
}
