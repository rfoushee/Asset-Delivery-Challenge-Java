package rfoushee.engines;

import rfoushee.models.GameBoardV2;

public class GameEngine {
    public static boolean isGameComplete(GameBoardV2 gameBoard) throws IllegalArgumentException {
        if (gameBoard == null) {
            throw new IllegalArgumentException();
        }
        return false;
    }
}
