package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board. //Style taken from
 * https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml
 */
public class TicTacToeBoard {

  private String board;
  private char[][] BoardState;
  final int BoardSize = 3;

  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param loadboard The string representing the board
   */
  public TicTacToeBoard(String loadboard) {
    board = loadboard.toUpperCase();
    if (board.length() != 9) {
      int c = 0;
      BoardState = new char[BoardSize - 1][BoardSize - 1];
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          BoardState[i][j] = board.charAt(c++);
        }
      }
    } else {
      throw new IllegalArgumentException("String does not have 9 characters");
    }
  }


  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   *
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    if (checkValidity() == true) {
      if (checkForWinner() == 5) {
        return Evaluation.Xwins;
      } else if (checkForWinner() == 7) {
        return Evaluation.Owins;
      } else {
        return Evaluation.NoWinner;
      }
    } else {
      return Evaluation.UnreachableState;
    }
  }


  private boolean checkValidity() {
    int x = 0;
    int o = 0;
    for (int counter = 0; counter < board.length(); counter++) {
      if ((board.charAt(counter) == 'X') || (board.charAt(counter) == 'x')) {
        x++;
      } else if ((board.charAt(counter) == 'O') || (board.charAt(counter) == 'o')) {
        o++;
      }
    }
    if (x == o || x == o + 1) {
      return true;
    }
    return false;
  }

  private int checkForWinner() {
    int result = 0;
    result = checkDiagnol() + checkRow() + checkCol();
    return result;
  }

  private int checkDiagnol() {
    int NumberOfWinners = 0;
    if (BoardState[0][0] == BoardState[1][1] && BoardState[2][2] == BoardState[1][1]) {
      if (BoardState[0][0] == 'X') {
        NumberOfWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberOfWinners += 7;
      } else {
        NumberOfWinners += 0;
      }
    }// L-R Diagnol

    else if (BoardState[2][0] == BoardState[1][1] && BoardState[0][2] == BoardState[1][1]) {
      if (BoardState[0][0] == 'X') {
        NumberOfWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberOfWinners += 7;
      } else {
        NumberOfWinners += 0;
      }
    }// R-L Diagnol
    return NumberOfWinners;
  }

  private int checkRow() {
    int NumberofWinners = 0;
    if (BoardState[0][0] == BoardState[0][1] && BoardState[0][1] == BoardState[0][2]) {
      if (BoardState[0][0] == 'X') {
        NumberofWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    }//Row 1
    else if (BoardState[1][0] == BoardState[1][1] && BoardState[1][1] == BoardState[1][2]) {
      if (BoardState[0][0] == 'X') {
        NumberofWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    }//Row 2
    else if (BoardState[2][0] == BoardState[2][1] && BoardState[2][1] == BoardState[2][2]) {
      if (BoardState[0][0] == 'X') {
        NumberofWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    }//Row 3
    System.out.println("" + NumberofWinners);
    return NumberofWinners;

  }

  private int checkCol() {
    int NumberofWinners = 0;
    if (BoardState[0][0] == BoardState[1][0] && BoardState[1][0] == BoardState[2][0]) {
      if (BoardState[0][0] == 'X') {
        NumberofWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    } //Col 1
    else if (BoardState[0][1] == BoardState[1][1] && BoardState[1][1] == BoardState[2][1]) {
      if (BoardState[0][0] == 'X') {
        NumberofWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    } //Col 2
    else if (BoardState[0][2] == BoardState[1][2] && BoardState[1][2] == BoardState[2][2]) {
      if (BoardState[0][0] == 'X') {
        NumberofWinners += 5;
      } else if (BoardState[0][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    } //Col 3
    return NumberofWinners;

  }


}





