package rfoushee.engines;

import org.junit.jupiter.api.Test;

import rfoushee.models.GameBoardV2;
import rfoushee.models.WinningPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;

public class GameEngineTests {

    @Test
    void isGameComplete_should_return_false_given_empty_board() {
        // GIVEN: empty GameBoard
        GameBoardV2 gameBoard = new GameBoardV2();

        // WHEN IsGameComplete is called
        boolean result = GameEngine.isGameComplete(gameBoard);

        // THEN: IsGameComplete returns false
        assertFalse(result);
    }

    @Test
    void isGameComplete_should_throw_illegalargumentexception_given_null_board() {
        // WHEN IsGameComplete is called
        assertThrows(IllegalArgumentException.class, () -> GameEngine.isGameComplete(null));
    }

    @Test
    void getWinner_should_throw_illegalargumentexception_given_null_board() {
        // WHEN IsGameComplete is called
        assertThrows(IllegalArgumentException.class, () -> GameEngine.getWinner(null));
    }

    @Test
    void getWinner_should_return_true_given_X_winning_board() {
        // GIVEN: mocked game board with X winning state
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        xMoves.add(0);
        xMoves.add(1);
        xMoves.add(2);
        HashSet<Integer> yMoves = new HashSet<>();
        xMoves.add(4);
        xMoves.add(5);
        xMoves.add(7);
        playersMoves.add(xMoves);
        playersMoves.add(yMoves);

        // GIVEN: empty GameBoard
        GameBoardV2 gameBoard = new GameBoardV2();

        // WHEN IsGameComplete is called
        WinningPlayer winner = GameEngine.getWinner(gameBoard);

        // THEN: getWinner returns true
        assertEquals(winner, WinningPlayer.X);
    }
}
