package rfoushee.models;

import java.util.ArrayList;
import java.util.HashSet;

public class WinningPositions {

    public static ArrayList<HashSet<Integer>> getPositions() {
        // create class as singleton and move intialization to it given more time
        ArrayList<HashSet<Integer>> positions = new ArrayList<>();

        // there are 8 winning positions
        HashSet<Integer> topRow = new HashSet<>();
        topRow.add(0);
        topRow.add(1);
        topRow.add(2);

        HashSet<Integer> middleRow = new HashSet<>();
        middleRow.add(3);
        middleRow.add(4);
        middleRow.add(5);

        HashSet<Integer> bottomRow = new HashSet<>();
        bottomRow.add(6);
        bottomRow.add(7);
        bottomRow.add(8);

        HashSet<Integer> leftColumn = new HashSet<>();
        leftColumn.add(0);
        leftColumn.add(3);
        leftColumn.add(6);

        HashSet<Integer> middleColumn = new HashSet<>();
        middleColumn.add(1);
        middleColumn.add(4);
        middleColumn.add(7);

        HashSet<Integer> rightColumn = new HashSet<>();
        rightColumn.add(2);
        rightColumn.add(5);
        rightColumn.add(8);

        HashSet<Integer> diagonal1 = new HashSet<>();
        diagonal1.add(0);
        diagonal1.add(4);
        diagonal1.add(8);

        HashSet<Integer> diagonal2 = new HashSet<>();
        diagonal2.add(2);
        diagonal2.add(4);
        diagonal2.add(6);

        positions.add(topRow);
        positions.add(middleRow);
        positions.add(bottomRow);
        positions.add(leftColumn);
        positions.add(middleColumn);
        positions.add(rightColumn);
        positions.add(diagonal1);
        positions.add(diagonal2);

        return positions;
    }
}
