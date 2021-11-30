# Ultimate Tic-Tac-Toe

*Ultimate Tic-Tac-Toe* is an extension of *Tic-Tac-Toe. Tic-Tac-Toe* is played on a 3x3 board where players mark either *X* or *O.* The first player to either fill a row, column, or diagonal with their mark wins the game. If neither players are able to do so before the board is filled, the game is a draw.

In extension, *Ultimate Tic-Tac-Toe*, plays with similar rules to its predecessor, however each tile in the 3x3 board is its own individual *Tic-Tac-Toe*  game. When a player makes a move on a specific board, the next board they must play is the previous player's indexed move.

---

### Features

* Well-rounded error handling system for Input Mismatch.
* Three custom game-modes: Player vs. Player, Player vs. AI, AI vs. AI
* Ultimate TTT ruleset and game condition fully implemented
* Player abstraction to allow creation of new types of players with custom abilities and selection handling.
* **TODO**: Smart AI, Show player available boards and squares, Update to dynamic size board handling

---

### Running the Application

To run the application, please compile all classes (or download their pre-compiled version [here](http://github.com/AruGyani/UltimateTTT)). From there, ensure all classes are in the same folder and execute `java Driver` to run the program.

---

### What I'd Do Differently

After developing this project, there are a few changes I'd make if I were to do it again.

1. Improve modularity of UltimateTTT board to allow for dynamic sized games and custom experience.
2. Improve Computer player AI by modeling after Chess Engines using MiniMax.
3. Create tiered difficulty system for players to play AI at different levels.


Developed by **Aru Gyani**
