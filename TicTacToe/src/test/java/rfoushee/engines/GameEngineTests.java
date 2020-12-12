package rfoushee.engines;

import org.junit.jupiter.api.Test;

import rfoushee.models.GameBoardV2;
import rfoushee.models.WinningPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void isGameComplete_should_return_false_given_board_with_remaining_moves() {
        // GIVEN: mocked player moves
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        HashSet<Integer> oMoves = new HashSet<>();
        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        boolean result = GameEngine.isGameComplete(gameBoard);

        // THEN: isGameComplete returns false
        assertFalse(result);
    }

    @Test
    void isGameComplete_should_return_true_given_board_with_no_remaining_moves() {
        // GIVEN: mocked player moves
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        xMoves.add(0);
        xMoves.add(2);
        xMoves.add(5);
        xMoves.add(6);
        xMoves.add(7);
        HashSet<Integer> oMoves = new HashSet<>();
        oMoves.add(1);
        oMoves.add(3);
        oMoves.add(4);
        oMoves.add(8);

        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        boolean result = GameEngine.isGameComplete(gameBoard);

        // THEN: isGameComplete returns true
        assertTrue(result);
    }

    @Test
    void isGameComplete_should_return_false_given_board_with_no_winner() {
        // GIVEN: mocked player moves
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        xMoves.add(0);
        xMoves.add(8);
        xMoves.add(1);
        xMoves.add(3);
        HashSet<Integer> oMoves = new HashSet<>();
        oMoves.add(4);
        oMoves.add(5);
        oMoves.add(7);

        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        boolean result = GameEngine.isGameComplete(gameBoard);

        // THEN: isGameComplete returns false
        assertFalse(result);
    }

    @Test
    void getWinner_should_throw_illegalargumentexception_given_null_board() {
        // WHEN IsGameComplete is called
        assertThrows(IllegalArgumentException.class, () -> GameEngine.getWinner(null));
    }

    @Test
    void getWinner_should_return_playerX_given_X_winning_board() {
        // GIVEN: mocked game board with X winning state
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        xMoves.add(0);
        xMoves.add(8);
        xMoves.add(1);
        xMoves.add(2);
        HashSet<Integer> oMoves = new HashSet<>();
        oMoves.add(4);
        oMoves.add(5);
        oMoves.add(7);
        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        WinningPlayer winner = GameEngine.getWinner(gameBoard);

        // THEN: getWinner returns true
        assertEquals(winner, WinningPlayer.X);
    }

    @Test
    void getWinner_should_return_playerO_given_O_winning_board() {
        // GIVEN: mocked game board with X winning state
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        xMoves.add(0);
        xMoves.add(1);
        xMoves.add(3);
        HashSet<Integer> oMoves = new HashSet<>();
        oMoves.add(2);
        oMoves.add(4);
        oMoves.add(6);
        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        WinningPlayer winner = GameEngine.getWinner(gameBoard);

        // THEN: getWinner returns true
        assertEquals(winner, WinningPlayer.O);
    }

    @Test
    void getWinner_should_return_NONE_given_no_winner_board() {
        // GIVEN: mocked game board with X winning state
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        xMoves.add(0);
        xMoves.add(1);
        xMoves.add(7);
        HashSet<Integer> oMoves = new HashSet<>();
        oMoves.add(2);
        oMoves.add(4);
        oMoves.add(3);
        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        WinningPlayer winner = GameEngine.getWinner(gameBoard);

        // THEN: getWinner returns true
        assertEquals(winner, WinningPlayer.NONE);
    }

    @Test
    void getWinner_should_return_NONE_given_no_player_moves_board() {
        // GIVEN: mocked game board with X winning state
        ArrayList<HashSet<Integer>> playersMoves = new ArrayList<>();
        HashSet<Integer> xMoves = new HashSet<>();
        HashSet<Integer> oMoves = new HashSet<>();
        playersMoves.add(xMoves);
        playersMoves.add(oMoves);

        // GIVEN: mocked GameBoard
        GameBoardV2 gameBoard = new GameBoardV2(playersMoves);

        // WHEN IsGameComplete is called
        WinningPlayer winner = GameEngine.getWinner(gameBoard);

        // THEN: getWinner returns true
        assertEquals(winner, WinningPlayer.NONE);
    }
}
