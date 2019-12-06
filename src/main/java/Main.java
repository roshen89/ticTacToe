import java.util.Scanner;

/**
 * @author ROSH - 11/28/2019
 */
public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    TicTacToe game = new TicTacToe();
    game.initializeBoard();
    System.out.println("TicTacToe Game Started");
    do {
      System.out.println("Current board:");
      game.printBoard();
      int row;
      int col;
      do {
        System.out.println("Player " + game.getCurrentPlayer() + ": enter row and column (with space) for your mark");
        row = scan.nextInt() - 1;
        col = scan.nextInt() - 1;
      }
      while (!game.placeMark(row, col));
      game.changePlayer();
    }
    while (game.checkForWinner() && !game.isBoardFull());
    if (game.isBoardFull() && game.checkForWinner()) {
      System.out.println("Finished with draw");
    } else {
      System.out.println("Current board:");
      game.printBoard();
      game.changePlayer();
      System.out.println(Character.toUpperCase(game.getCurrentPlayer()) + " won.");
    }
  }
}
