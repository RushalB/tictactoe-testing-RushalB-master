package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board. Style taken from
 * https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml
 */
public class TicTacToeBoard {

  private String board;
  private char[][] boardState;
  final int BOARDSIZE = 3; //side

  /**
   * This method should load a string into your TicTacToeBoard class.
   *
   * @param loadBoard The string representing the board
   */
  public TicTacToeBoard(String loadBoard) {
    board = loadBoard.toUpperCase();
    if (board.length() > 8) {
      int c = 0;
      boardState = new char[BOARDSIZE][BOARDSIZE];
      for (int i = 0; i <= 2; i++) {
        for (int j = 0; j <= 2; j++) {
          boardState[i][j] = board.charAt(c++);
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

    int checkForWinner = checkForWinner();
    if (checkValidity() == true) {
      if (checkForWinner == 5) {
        return Evaluation.Xwins;
      } else if (checkForWinner == 7) {
        return Evaluation.Owins;
      } else if (checkForWinner == 0) {
        return Evaluation.NoWinner;
      } else {
        return Evaluation.UnreachableState;
      }
    } else {
      return Evaluation.UnreachableState;
    }
  }

  /**
   * Checks if the board has valid inputs that is number of Xs should be either equal to or one more
   * than number of Os
   *
   * @return true if valid inputs are entered,false if invalid inputs are entered
   */
  private boolean checkValidity() {
    int xNumber = 0;
    int oNumber = 0;
    for (int counter = 0; counter < board.length(); counter++) { //counts numbers of Xs and Os
      if ((board.charAt(counter) == 'X') || (board.charAt(counter) == 'x')) {
        xNumber++;
      } else if ((board.charAt(counter) == 'O') || (board.charAt(counter) == 'o')) {
        oNumber++;
      }
    }
    if (xNumber == oNumber || xNumber == oNumber + 1) {
      return true;
    }
    return false;
  }

  /**
   * Checks the number of wins in the current state of board.
   *
   * @return result which is an int stating Number of Wins(5 for X and & for )
   */
  private int checkForWinner() {
    int result = 0;

    result = checkDiagonal() + checkRow() + checkCol();
    return result;
  }

  /**
   * Checks if there are any wins diagonally Assign 5 for every X win Assigns 7 for every O win to
   * the Number of wins counter
   *
   * @return NumberofWinners which gives number of diagonal wins
   */
  private int checkDiagonal() {
    int NumberOfWinnersD = 0;
    if (boardState[0][0] == boardState[1][1] && boardState[2][2] == boardState[1][1]) {
      if (boardState[0][0] == 'X') {
        NumberOfWinnersD = NumberOfWinnersD + 5;
      } else if (boardState[0][0] == 'O') {
        NumberOfWinnersD += 7;
      } else {
        NumberOfWinnersD += 0;
      }
    }// L-R Diagnol

    else if (boardState[2][0] == boardState[1][1] && boardState[0][2] == boardState[1][1]) {
      if (boardState[1][1] == 'X') {
        NumberOfWinnersD += 5;
      } else if (boardState[1][1] == 'O') {
        NumberOfWinnersD += 7;
      } else {
        NumberOfWinnersD += 0;
      }
    }// R-L Diagnol
    return NumberOfWinnersD;
  }

  /**
   * Checks if there are any wins horizontally Assign 5 for every X win Assigns 7 for every O win to
   * the Number of wins counter
   *
   * @return NumberofWinners which gives number of row wins
   */
  private int checkRow() {
    int NumberofWinnersR = 0;
    if ((boardState[0][0] == 'X') && (boardState[0][1] == 'X') && (boardState[0][2] == 'X')) {
      NumberofWinnersR += 5;
    } else if ((boardState[0][0] == 'O') && (boardState[0][1] == 'O') && (boardState[0][2]
        == 'O')) {
      NumberofWinnersR += 7;
    }
    //Row 1
    if ((boardState[1][0] == 'X') && (boardState[1][1] == 'X') && (boardState[1][2] == 'X')) {
      NumberofWinnersR += 5;
    } else if ((boardState[1][0] == 'O') && (boardState[1][1] == 'O') && (boardState[1][2]
        == 'O')) {
      NumberofWinnersR += 7;
    } //Row 2
    if ((boardState[2][0] == 'X') && (boardState[2][1] == 'X') && (boardState[2][2] == 'X')) {
      NumberofWinnersR += 5;
    } else if ((boardState[2][0] == 'O') && (boardState[2][1] == 'O') && (boardState[2][2]
        == 'O')) {
      NumberofWinnersR += 7;
    } //Row 3

    return NumberofWinnersR;

  }

  /**
   * Checks if there are any wins vertically Assign 5 for every X win Assigns 7 for every O win to
   * the Number of wins counter
   *
   * @return NumberofWinners which gives number of column wins
   */
  private int checkCol() {
    int NumberofWinners = 0;
    if (boardState[0][0] == boardState[1][0] && boardState[1][0] == boardState[2][0]) {
      if (boardState[1][0] == 'X') {
        NumberofWinners += 5;
      } else if (boardState[1][0] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    } //Col 1
    else if (boardState[0][1] == boardState[1][1] && boardState[1][1] == boardState[2][1]) {
      if (boardState[1][1] == 'X') {
        NumberofWinners += 5;
      } else if (boardState[1][1] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    } //Col 2
    else if (boardState[0][2] == boardState[1][2] && boardState[1][2] == boardState[2][2]) {
      if (boardState[1][2] == 'X') {
        NumberofWinners += 5;
      } else if (boardState[1][2] == 'O') {
        NumberofWinners += 7;
      } else {
        NumberofWinners += 0;
      }
    } //Col 3
    return NumberofWinners;

  }


}





