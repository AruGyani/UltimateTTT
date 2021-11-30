// Aru Gyani
// CS 2336.002

import java.util.ArrayList;

public class Board {
    private int rows = 3, cols = 3;
    public int length;

    private char[] board;
    
    private boolean accessible = true;
    private boolean gameOver = false;

    private Player winner = null;
    
    public Board() {
        board = new char[rows * cols];
        length = board.length;

        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
    }

    public void move(int selectedSquare, Player player) {
        board[selectedSquare] = player.getValue();

        if (winner == null) checkWinner(player);
    }

    public void checkWinner(Player player) {
        // Columns
        if (board[0] != '-' && board[0] == board[3] && board[0] == board[6]) setWinner(player);
        if (board[1] != '-' && board[1] == board[4] && board[1] == board[7]) setWinner(player);
        if (board[2] != '-' && board[2] == board[5] && board[2] == board[8]) setWinner(player);

        // Rows
        if (board[0] != '-' && board[0] == board[1] && board[0] == board[2]) setWinner(player);
        if (board[3] != '-' && board[3] == board[4] && board[3] == board[5]) setWinner(player);
        if (board[6] != '-' && board[6] == board[7] && board[6] == board[8]) setWinner(player);

        // Diagonal
        if (board[0] != '-' && board[0] == board[4] && board[0] == board[8]) setWinner(player);
        if (board[2] != '-' && board[2] == board[4] && board[2] == board[6]) setWinner(player);
    }

    public void setWinner(Player player) {
        this.gameOver = true;
        this.winner = player;
    }

    // Return all available squares
    public ArrayList<Integer> getAvailableSquares() {
        ArrayList<Integer> availableSquares = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') availableSquares.add(i);
        }

        return availableSquares;
    }

    public boolean isAvailable(int selectedSquare) {
        return board[selectedSquare] == '-';
    }

    // Check if board is full
    public boolean isFull() {
        boolean full = true;

        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') full = false;
        }

        return full;
    }

    public void printRow(int row) {
        if (row >= 0 && row <= rows) {
            int start = row * 3;
            int end = row * 3 + 2;

            for (int i = start; i <= end; i++) {
                System.out.print("| ");

                if (gameOver && winner.getValue() == '-') System.out.print('*'); 
                else if (gameOver && board[i] == '-') System.out.print('*');
                else if (board[i] != '-') System.out.print(board[i]);
                else System.out.print(i);
                
                System.out.print(" ");
            }

            System.out.print("|\t");

        } else System.out.println("ERROR. Invalid row.");
    }

    public boolean isAccessible() { return accessible; }
    public boolean isGameOver() { return gameOver; }

    public void setAccessible(boolean accessible) { this.accessible = accessible; }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public Player getWinner() { return winner; }
}
