// Aru Gyani
// CS 2336.002

import java.util.Scanner;

public abstract class Player {
    private char value;

    public Player(char value) {
        this.value = value;
    }

    public char getValue() { return this.value; }

    public abstract int selectBoard(Scanner s, Board[] boards);
    public abstract int selectSquare(Scanner s, Board board);
}
