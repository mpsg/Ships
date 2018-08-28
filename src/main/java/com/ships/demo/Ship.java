package com.ships.demo;

class Ship {
    private int size;
    private int hitsLeft;
    Ship(int size) {
        this.hitsLeft = this.size = size;
    }
    int getSize() {
        return this.size;
    }
    //returns true if ship is destroyed and there are no more hits left
    boolean hit() {
        this.hitsLeft--;
        if (this.hitsLeft > 0) {
            return false;
        } else {
            return true;
        }
    }
}
