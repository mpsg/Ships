package com.ships.demo;

import java.util.ArrayList;

public class Game {
    private int gameID;
    private int player1ID;
    private int player2ID;
    private Board boardPlayer1;
    private Board boardPlayer2;
    //temporary method for testing the logic for creating computer board
    public String testComputerBoardCreation(int boardSize, int shipsNum, int smallestShipSize) {
        Board board = new Board(boardSize);
        ShipFactory shipFactory = new ShipFactory(shipsNum, smallestShipSize);
        ArrayList<Ship> ships = shipFactory.makeShips();
        board.insertShipsAtRandom(ships);
        return board.toString();
    }
}
