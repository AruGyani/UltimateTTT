// Aru Gyani
// CS 2336.002

import java.util.ArrayList;
import java.util.Scanner;

public class BasicComputer extends Player {
    public BasicComputer(char value) {
        super(value);
    }

    public int selectBoard(Scanner s, Board[] boards) { 
        ArrayList<Integer> availableBoards = new ArrayList<>();

        // get all available boards
        for (int i = 0; i < boards.length; i++) {
            if (boards[i].isAccessible()) availableBoards.add(i);
        }

        // select random index from available boards
        int randomIndex = (int) (Math.random() * availableBoards.size());

        
        return availableBoards.get(randomIndex);
    }

    public int selectSquare(Scanner s, Board board) {
        ArrayList<Integer> availableSquares = board.getAvailableSquares();

        int randomIndex = (int) (Math.random() * availableSquares.size());

        // returns randomly selected available square
        return availableSquares.get(randomIndex);
    }
}
