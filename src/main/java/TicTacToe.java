/**
 * @author ROSH - 12/6/2019
 */
public class TicTacToe {

  private char[][] board;
  private char currentPlayerMark;

  TicTacToe() {
    board = new char[3][3];
    currentPlayerMark = 'X';
    initializeBoard();
  }

  char getCurrentPlayer() {
    return currentPlayerMark;
  }

  void initializeBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  void printBoard() {
    System.out.println("-------------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

  boolean isBoardFull() {
    boolean isFull = true;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          isFull = false;
          break;
        }
      }
    }
    return isFull;
  }

  boolean checkForWinner() {
    return (!checkRowsForWinner() && !checkColumnsForWinner() && !checkDiagonalsForWinner());
  }

  private boolean checkRowsForWinner() {
    for (int i = 0; i < 3; i++) {
      if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
        return true;
      }
    }
    return false;
  }

  private boolean checkColumnsForWinner() {
    for (int i = 0; i < 3; i++) {
      if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonalsForWinner() {
    return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
  }

  private boolean checkRowCol(char c1, char c2, char c3) {
    return ((c1 != '-') && (c1 == c2) && (c2 == c3));
  }


  void changePlayer() {
    if (currentPlayerMark == 'X') {
      currentPlayerMark = '0';
    } else {
      currentPlayerMark = 'X';
    }
  }

  boolean placeMark(int row, int col) {
    if ((row >= 0) && (row < 3)) {
      if ((col >= 0) && (col < 3)) {
        if (board[row][col] == '-') {
          board[row][col] = currentPlayerMark;
          return true;
        }
      }
    }
    System.out.println("Please, Choose Another Row&Column");
    return false;
  }
}
