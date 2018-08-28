package com.ships.demo;

public class PositionedShip {
    private Ship ship;
    //coordinates of the ship beginning
    private int x;
    private int y;
    private Orientation orientation;
    public PositionedShip(Ship ship, int x, int y, Orientation orientation) {
        this.ship = ship;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
    Orientation getOrientation() {
        return this.orientation;
    }
    Ship getShip() { return this.ship; }
}
