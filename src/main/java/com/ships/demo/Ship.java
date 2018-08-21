package com.ships.demo;

public class Ship {
    private int size;
    private int hitsLeft;
    public Ship(int size) {
        this.hitsLeft = this.size = size;
    }
    public int getSize() {
        return this.size;
    }
    //returns true if ship is destroyed and there are no more hits left
    public boolean hit() {
        this.hitsLeft--;
        if (this.hitsLeft > 0) {
            return false;
        } else {
            return true;
        }
    }
}
