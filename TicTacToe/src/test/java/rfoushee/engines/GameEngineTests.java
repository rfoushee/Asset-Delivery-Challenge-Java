package rfoushee.engines;

import org.junit.jupiter.api.Test;

import rfoushee.models.GameBoardV2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
