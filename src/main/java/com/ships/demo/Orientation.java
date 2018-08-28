package com.ships.demo;

import java.util.Random;

enum Orientation {
    RIGHT{
        @Override
        Orientation getNext() { return Orientation.DOWN; }
    },
    DOWN{
        @Override
        Orientation getNext() { return Orientation.LEFT; }
    },
    LEFT{
        @Override
        Orientation getNext() { return Orientation.UP; }
    },
    UP{
        @Override
        Orientation getNext() { return Orientation.RIGHT; }
    };
    static Orientation getRandomOrientation() {
        Random rand = new Random();
        return Orientation.values()[rand.nextInt(4)];
    }
    abstract Orientation getNext();
}
