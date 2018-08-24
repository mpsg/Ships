package com.ships.demo.service;

import com.ships.demo.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    public String testBoard(int boardSize, int shipsNum, int smallestShipSize) {
        Game game = new Game();
        String str = game.testComputerBoardCreation(boardSize, shipsNum, smallestShipSize);
        return str;
    }
}
