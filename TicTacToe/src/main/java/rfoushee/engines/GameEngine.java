package rfoushee.engines;

import java.util.ArrayList;
import java.util.HashSet;

import rfoushee.models.GameBoardV2;
import rfoushee.models.WinningPlayer;
import rfoushee.models.WinningPositions;

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
        ArrayList<HashSet<Integer>> winningPositions = WinningPositions.getPositions();
        boolean isXPlayer = true;
        for (HashSet<Integer> playersMove : gameBoard.getGameState()) {
            if (playersMove.size() >= 3) {
                for (HashSet<Integer> win : winningPositions) {
                    if (playersMove.containsAll(win)) {
                        return isXPlayer ? WinningPlayer.X : WinningPlayer.O;
                    }
                }
            }
            isXPlayer = false;
        }

        return WinningPlayer.NONE;
    }
}
