// Aru Gyani
// CS 2336.002

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
    public Human(char value) {
        super(value);
    }

    public int selectBoard(Scanner s, Board[] boards) {
        int selectedBoard = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Please select a valid board : ");
                selectedBoard = s.nextInt();

                if (selectedBoard >= 0 && selectedBoard < boards.length) {
                    if (boards[selectedBoard].isAccessible()) isValid = true;
                    else System.out.println("\nError. This board is not accessible.\n");
                } else System.out.println("\nError. Must enter an integer between 0 and " + (boards.length - 1) + "\n");
            } catch (InputMismatchException e) {
                System.out.println("\nError. Must enter an integer.\n");
                s.nextLine();
            }
        }

        return selectedBoard;
    }

    public int selectSquare(Scanner s, Board board) {
        int selectedSquare = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Please select a valid square on the selected board : ");
                selectedSquare = s.nextInt();

                if (selectedSquare >= 0 && selectedSquare < board.length) {
                    if (board.isAvailable(selectedSquare)) isValid = true;
                    else System.out.println("\n Error. This square is unavailable.\n");
                } else System.out.println("\nError. Must enter an integer between 0 and " + (board.length - 1));
            } catch (InputMismatchException e) {
                System.out.println("\nError. Must enter an integer.\n");
                s.nextLine();
            }
        }

        return selectedSquare;
    }
}
