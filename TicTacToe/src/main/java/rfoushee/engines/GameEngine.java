package rfoushee.engines;

import rfoushee.models.GameBoardV2;
import rfoushee.models.WinningPlayer;

public class GameEngine {
    public static boolean isGameComplete(GameBoardV2 gameBoard) throws IllegalArgumentException {
        if (gameBoard == null) {
            throw new IllegalArgumentException();
        }

        return false;
    }

    public static WinningPlayer getWinner(GameBoardV2 gameBoard) throws IllegalArgumentException {
        if (gameBoard == null) {
            throw new IllegalArgumentException();
        }

        return WinningPlayer.NONE;
    }
}
