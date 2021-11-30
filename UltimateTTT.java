// Aru Gyani
// CS 2336.002

import java.util.InputMismatchException;
import java.util.Scanner;

public class UltimateTTT {
    private Board[] boards;

    private Player[] players;
    private Player currentPlayer;

    private Scanner s;

    private boolean gameOver = false;

    public UltimateTTT() {
        boards = new Board[9];
        players = new Player[2];
        s = new Scanner(System.in);

        for (int i = 0; i < boards.length; i++)
            boards[i] = new Board();

        createPlayers();
    }

    public void createPlayers() {
        boolean isValid = false;
        int selection = -1;

        while (!isValid) {
            System.out.print("Please select a game mode:\n\t1 - Player vs Player\n\t2 - Player vs AI\n\t3 - AI vs AI\n\n> ");
            try {
                selection = s.nextInt();
                
                if (selection >= 1 && selection <= 3) isValid = true;
                else System.out.println("\nPlease enter an integer between 1 and 3\n");
            } catch (InputMismatchException e) {
                System.out.println("\nError. Please enter an integer.\n");
                s.nextLine();
            }
        }

        if (selection == 1) {
            players[0] = new Human('X');
            players[1] = new Human('O');
        } else if (selection == 2) {
            players[0] = new Human('X');
            players[1] = new BasicComputer('O');
        } else {
            players[0] = new BasicComputer('X');
            players[1] = new BasicComputer('O');
        }

        currentPlayer = players[0];
    }

    public void start() {
        System.out.println("\n===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
        print(); 

        int selectedBoard = -1, selectedSquare = -1;

        while (!gameOver) {
            System.out.println("\nCurrent Player is : " + currentPlayer.getValue());

            if (selectedBoard == -1) selectedBoard = currentPlayer.selectBoard(s, boards);
            System.out.println("Selected Board: " + selectedBoard);

            if (selectedSquare == -1) selectedSquare = currentPlayer.selectSquare(s, boards[selectedBoard]);
            System.out.println("Selected Square: " + selectedSquare);

            boards[selectedBoard].move(selectedSquare, currentPlayer);

            selectedBoard = updateAccessibleBoards(selectedSquare);
            selectedSquare = -1;

            print();
            printWinners();
            
            if (isFull()) {
                System.out.println("\nGame Over. Tie!");
                gameOver = true;
            } else {
                gameOver = checkWinner();

                if (gameOver) System.out.println("\nWinner is " + currentPlayer.getValue());
                else currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
            }
        }
    }

    public int updateAccessibleBoards(int selectedSquare) {
        for (int i = 0; i < boards.length; i++) {
            if (i != selectedSquare && !boards[i].isFull()) boards[i].setAccessible(true);
            else boards[i].setAccessible(false);
        }

        if (boards[selectedSquare].isFull()) return -1;
        else return selectedSquare;
    }

    public boolean isFull() {
        for (int i = 0; i < boards.length; i++) {
            if (!boards[i].isGameOver()) return false;
        }

        return true;
    }

    public boolean checkWinner() { 
        // Columns
        if (boards[0].getWinner() != null && boards[0].getWinner() == boards[3].getWinner() && boards[3].getWinner() == boards[6].getWinner()) return true;
        if (boards[1].getWinner() != null && boards[1].getWinner() == boards[4].getWinner() && boards[4].getWinner() == boards[7].getWinner()) return true;
        if (boards[2].getWinner() != null && boards[2].getWinner() == boards[5].getWinner() && boards[5].getWinner() == boards[8].getWinner()) return true;

        // Rows
        if (boards[0].getWinner() != null && boards[0].getWinner() == boards[1].getWinner() && boards[1].getWinner() == boards[2].getWinner()) return true;
        if (boards[3].getWinner() != null && boards[3].getWinner() == boards[4].getWinner() && boards[4].getWinner() == boards[5].getWinner()) return true;
        if (boards[6].getWinner() != null && boards[6].getWinner() == boards[7].getWinner() && boards[7].getWinner() == boards[8].getWinner()) return true;

        // Diagonals
        if (boards[0].getWinner() != null && boards[0].getWinner() == boards[4].getWinner() && boards[4].getWinner() == boards[8].getWinner()) return true;
        if (boards[2].getWinner() != null && boards[2].getWinner() == boards[4].getWinner() && boards[4].getWinner() == boards[6].getWinner()) return true;

        return false;
    }

    public void print() {
        for (int i = 0, j = 1, k = 2; i < boards.length - 2 && j < boards.length - 1 && k < boards.length;  i+=3, j+=3, k+=3) {
            for (int z = 0; z < boards[i].getRows() && z < boards[j].getRows() && z < boards[k].getRows(); z++) {
                System.out.print("\tBOARD#" + i + " "); boards[i].printRow(z);
                System.out.print("BOARD#" + j + " "); boards[j].printRow(z);
                System.out.print("BOARD#" + k + " "); boards[k].printRow(z);

                System.out.println("");
            }
        }
    }

    public void printWinners() {
        for (int i = 0; i < boards.length; i++)
            if (boards[i].getWinner() != null && boards[i].isGameOver()) 
                System.out.println("The Board#"+ i + " winner is "+ boards[i].getWinner().getValue());
    }
}