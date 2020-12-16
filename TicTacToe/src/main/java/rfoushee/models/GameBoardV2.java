package rfoushee.models;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents the board/state of a game of tic-tac-toe. state.get(0) contains
 * the 'X' players moves and state.get(1) is the 'O' players moves. 5 is the
 * maximum spaces a 'X' player may have, 4 is the maximum a 'O' player may have.
 * So for example, if player 1 had put an X in each space of the top row
 * state.get(0) would contain [0,1,2]
 */
public class GameBoardV2 {

    private ArrayList<HashSet<Integer>> state;

    public GameBoardV2() {
        this.state = new ArrayList<HashSet<Integer>>();
        this.state.add(new HashSet<Integer>(5));
        this.state.add(new HashSet<Integer>(4));
    }

    public GameBoardV2(ArrayList<HashSet<Integer>> state) {
        this.state = state;
    }

    public ArrayList<HashSet<Integer>> getGameState() {
        return state;
    }

    public boolean addMove(WinningPlayer player, int move) {

        if (move < 0 || move > 8) {
            return false;
        }
        HashSet<Integer> playersMoves = state.get(player == WinningPlayer.X ? 0 : 1);
        if (!playersMoves.contains(move)) {
            playersMoves.add(move);
            return true;
        }
        return false;
    }

}
