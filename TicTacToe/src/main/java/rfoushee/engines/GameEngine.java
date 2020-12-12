package rfoushee.engines;

import java.util.ArrayList;
import java.util.HashSet;

import rfoushee.models.GameBoardV2;
import rfoushee.models.WinningPlayer;
import rfoushee.models.WinningPositions;

/**
 * The engine to run a game of TicTacToe
 */
public class GameEngine {

    // 9 is the maximum number of moves
    private final static int MAX_NUMBER_OF_PLAYER_MOVES = 9;

    /**
     * Determines if the game is complete. A completed game has a winner or there
     * are no more moves to be made.
     *
     * @param gameBoard The gameboard.
     * @return boolean
     * @throws IllegalArgumentException
     */
    public static boolean isGameComplete(GameBoardV2 gameBoard) throws IllegalArgumentException {
        if (gameBoard == null) {
            throw new IllegalArgumentException();
        }

        int totalNumberOfMoves = 0;
        for (HashSet<Integer> playersMove : gameBoard.getGameState()) {
            totalNumberOfMoves += playersMove.size();
        }

        if (totalNumberOfMoves == MAX_NUMBER_OF_PLAYER_MOVES) {
            return true;
        }

        WinningPlayer winner = getWinner(gameBoard);
        return winner != WinningPlayer.NONE;
    }

    /**
     * determines if there is winner of the game. If no winner returns
     * WinningPlayer.NONE
     *
     * @param gameBoard
     * @return WinningPlayer The winning player of WinningPlayer.NONE
     * @throws IllegalArgumentException
     */
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
