package com.ships.demo;

public class PositionedShip {
    private Ship ship;
    //coordinates of the ship beginning
    private int x;
    private int y;
    //0 - extends to the right, 1 - to the bottom, 2 - to the left, 3 - towards the top
    private int orientation;
    public PositionedShip() {}
    public PositionedShip(Ship ship, int x, int y, int orientation) {
        this.ship = ship;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getOrientation() {
        return this.orientation;
    }
    public Ship getShip() { return this.ship; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Ship Information -----\n");
        sb.append("x: " + this.getX() + "\n");
        sb.append("y: " + this.getY() + "\n");
        sb.append("orientation: " + this.getOrientation() + "\n");
        sb.append("size: " + this.getShip().getSize() + "\n");
        sb.append("hits left: " + this.getShip().getHitsLeft() + "\n");
        sb.append("*****************************");
        return sb.toString();
    }
}
